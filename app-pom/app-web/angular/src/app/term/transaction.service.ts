import { Injectable, isDevMode } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, timer, throwError } from 'rxjs';
import { retry } from 'rxjs/operators';

import Ajv, {ValidateFunction} from "ajv"

import { BackendMessage } from './message';
import { AppConfigurationMessage, TerminalKind } from '../configuration-message.module';
import * as schema from './message.schema.json'
import { ConfigService } from 'app/config-service';

@Injectable()
export class TransactionService {

    /** URL to web api */
    private transactionsUrl: string;

    /** The global configuration */
    public configuration: AppConfigurationMessage;

	/** The terminal ID attached with the current session */
    private terminalId: string;

    public setTerminalId(terminalId: string) {
        this.terminalId = terminalId;
    }

    private validator: Ajv;
    private validateBackendMessage: ValidateFunction;

    private configService: ConfigService;

    constructor(private http: HttpClient) {
    }

    /** Called during application initialization (V7-179) */
    public configure(configuration: AppConfigurationMessage, configService: ConfigService) {

        this.configuration = configuration;
        this.configService = configService;

        if (this.configuration.backendURL === undefined) {
            throw new Error('Server did not provide us with backend URL, cannot initialize: ' + configuration);
        }

        let url: string = this.configuration.backendURL;
        if (!url.endsWith('/')) {
            url += '/';
        }

        this.transactionsUrl = url + 'transaction';
        console.log('TransactionService initialized with URL ' + this.transactionsUrl);

        this.configuration.useModernLegacyStyle = configuration.useModernLegacyStyle !== undefined && configuration.useModernLegacyStyle;

        // Load and compile JSON schema for messages.
        //let schema = require('./message.schema.json');
        this.validator = new Ajv();
        this.validateBackendMessage = this.validator.compile(schema);
        console.log('Messages validation set up');
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        if(this.configService.terminalConfig.backErrMessages?.enableMessage) {
            let title = ""
            let errorMessage = "";
            let errorSubMessage = "";
            switch (error.status) {
                case 500:
                    title = this.configService.terminalConfig.backErrMessages.error500Message?.title;
                    errorMessage = this.configService.terminalConfig.backErrMessages.error500Message?.message;
                    errorSubMessage = this.configService.terminalConfig.backErrMessages.error500Message?.subMessage;
                    break;
                case 504:
                case 502:
                case 503:
                case 408:
                    title = this.configService.terminalConfig.backErrMessages.error504Message?.title;
                    errorMessage = this.configService.terminalConfig.backErrMessages.error504Message?.message;
                    errorSubMessage = this.configService.terminalConfig.backErrMessages.error504Message?.subMessage;
                    break;
                default:
                    title = this.configService.terminalConfig.backErrMessages.defaultErrorMessage?.title;
                    errorMessage = this.configService.terminalConfig.backErrMessages.defaultErrorMessage?.message;
                    errorSubMessage = this.configService.terminalConfig.backErrMessages.defaultErrorMessage?.subMessage;
                    break;
            }
            return Promise.resolve(this.handleBackendMessage(this.spoofBackendMessage(title, errorMessage, errorSubMessage, error.status)))
        }
        return Promise.reject(error.message || error);
    }

    private hidePassword(message: any) {
        let msg = Object.assign({}, message)
        if (msg.fields !== undefined) {
            msg.fields = msg.fields
                .map(field => {
                    if (field.ispassword !== undefined) {
                        delete field.ispassword
                        return { ...field, value: field.value.replace(/./g, '*') };
                    }
                    return field;
                });
        }
        return msg;
    }

    fetchData(messageToSend: any): Promise<BackendMessage> {
      return this.runTransaction(undefined, messageToSend, undefined);
    }

    runTransaction(transid: String, message: any, parameters?: []): Promise<BackendMessage> {
        // Do not encore transid in the URL anymore
        message['transactionId'] = transid;
        message['parameters'] = parameters;
        const url = `${this.transactionsUrl}`;
        console.log('Starting transaction on backend (' + url + ')');
        if (isDevMode()) {
            console.log(this.hidePassword(message));
        }

        // Use a POST to be able to send JSON message to the server
        const httpOptions = {
            headers: new HttpHeaders({
              'Content-Type':  'application/json',
              'X-Auth-Token' : sessionStorage.getItem("TabSessionId")
            })
          };

        return this.http.post(url, message, httpOptions)
            .toPromise()
            .then((response) => {
                // https://stackoverflow.com/a/33851796
                return this.handleBackendMessage(response);
            })
            .catch((error) => this.handleError(error));
    }

    /**
     * Send the CLOSE message that terminates the backend HTTP session.
     *
     * Transport rationale (see session-CLOSE ticket):
     * - An async HttpClient POST fired from beforeunload/pagehide is routinely cancelled
     *   by the browser during document teardown, so the server never invalidates the
     *   session and it lingers in Redis until TTL expiry.
     * - navigator.sendBeacon cannot set the X-Auth-Token header, so it cannot target the
     *   per-tab session.
     * - Synchronous XHR works but is deprecated on the main thread.
     * - fetch(..., { keepalive: true }) is the sanctioned page-dismissal transport: it
     *   survives unload AND can set X-Auth-Token. It requires the backend to handle
     *   CLOSE fully synchronously (no DeferredResult), which WebController does.
     *
     * Body is well under the 64 KB keepalive cap. Safe to call from beforeunload,
     * pagehide and ngOnDestroy alike: it never blocks the main thread.
     */
    public sendCloseMessage(transid?: String): void {
        const url = this.transactionsUrl;
        if (!url) {
            return;
        }
        const authToken = sessionStorage.getItem('TabSessionId');
        const body = JSON.stringify({
            attentionKey: 'CLOSE',
            transactionId: transid ?? null,
            parameters: null
        });
        try {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'X-Auth-Token': authToken ?? ''
                },
                body,
                keepalive: true,
                credentials: 'include'
            }).catch(() => { /* unload path: nothing actionable */ });
        } catch (e) {
            // Last-resort fallback for engines without keepalive fetch. sendBeacon cannot
            // carry X-Auth-Token; the cookie-resolved session is better than nothing.
            try {
                if (navigator.sendBeacon) {
                    navigator.sendBeacon(url, new Blob([body], { type: 'application/json' }));
                }
            } catch (e2) {
                console.error('CLOSE sendBeacon fallback failed:', e2);
            }
        }
    }

    private handleBackendMessage(response): BackendMessage {
        if (isDevMode()) {
            console.log('Response from backend received', response);
        }


        // Since TypeScript cannot type-validate JSON at runtime,
        // use a JSON schema generated fron TypeScript classes
        if (!this.validateBackendMessage(response)) {
             // Chrome-debug friendly
            console.error('Backend JSON message validation error: "' + this.validator.errorsText(this.validateBackendMessage.errors) + '"', this.validateBackendMessage.errors);
            if (isDevMode()) {
                console.error('invalid json:', response);
            }
            throw new Error('Backend JSON message validation error');
        }

        // Seems legit
        return response as BackendMessage;
    }

    public is5250() {
        return this.configuration.emulatedTerminal == TerminalKind.Term5250;
    }

    public is6680() {
    	return this.configuration.emulatedTerminal == TerminalKind.Term6680;
    }

    waitForBreakMessage(terminalId?: string): Observable<BackendMessage> {
        // Set the terminal ID if it exist
        if (terminalId) {
            this.terminalId = terminalId;
        }
    
        let url: string = this.configuration.backendURL;
        if (!url.endsWith('/')) {
            url += '/';
        }
        url = url + 'break/message';

        const message = { terminalId: this.terminalId };

        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'X-Auth-Token': sessionStorage.getItem("TabSessionId")
            })
        };

        return this.http.post<BackendMessage>(url, message, httpOptions).pipe(
            retry({
                count: Infinity,  // Retry forever
                delay: (error, retryCount) => {
                    // Timeout errors - retry immediately (or with small delay)
                    if (error.status === 504 || error.status === 502 || error.status === 503 || error.status === 408) {
                        return timer(100);  // 100ms delay before retry
                    }
                    
                    // Network errors (offline, connection refused) - retry with backoff
                    if (error.status === 0) {
                        const backoffDelay = Math.min(1000 * Math.pow(2, retryCount - 1), 30000);
                        console.log(`Network error, retrying in ${backoffDelay}ms...`);
                        return timer(backoffDelay);
                    }
                    
                    // Other errors (401, 403, 500) - don't retry, propagate error
                    console.error('Break message error:', error);
                    return throwError(() => error);
                }
            })
    	);
    }

    sendBreakMessageResponse(attentionKey: string, cursorPosition?: number, fields?: any[], activeField?: string): Observable<BackendMessage> {
        let url: string = this.configuration.backendURL;
        if (!url.endsWith('/')) {
            url += '/';
        }
        url = url + 'break/message';

        const message = { terminalId: this.terminalId, attentionKey: attentionKey, cursorPosition: cursorPosition || 0, fields: fields || [], activeField: activeField || "" };

        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'X-Auth-Token': sessionStorage.getItem('TabSessionId')
            })
        };

        return this.http.post<BackendMessage>(url, message, httpOptions);
    }

        private spoofBackendMessage (title : string, errorMessage: string, errorSubMessage: string, status: number) : Object {
        const buttonMessage = this.configService.terminalConfig.backErrMessages.buttonMessage;
        if (this.configService.terminalConfig.backErrMessages.displayStatus) {
            title += " / Status: " + status;
        }
        if (this.configService.terminalConfig.backErrMessages.displayTimestamp) {
        	title += " / " + new Date(Date.now()).toUTCString();
        }
        return {
            "messages": [
                {
                    "command": "windowComponents",
                    "maps": [
                        {
                            "component": "back-err-message",
                            "overlay": false,
                            "startLineNumber": 0,
                            "fields": [
                                {
                                    "type": "simple",
                                    "id": "title",
                                    "data": title,
                                    "attributes": {
                                        "intensity": "HIGH",
                                        "protection": "PROT",
                                        "color": "white"
                                    }
                                },
                                {
                                    "type": "simple",
                                    "id": "errorMessage",
                                    "data": errorMessage,
                                    "attributes": {
                                        "intensity": "NORM",
                                        "protection": "PROT",
                                    }
                                },
                                {
                                    "type": "simple",
                                    "id": "errorSubMessage",
                                    "data": errorSubMessage,
                                    "attributes": {
                                        "intensity": "NORM",
                                        "protection": "PROT",
                                    }
                                },
                                {
                                    "type": "simple",
                                    "id": "buttonMessage",
                                    "data": buttonMessage,
                                    "attributes": {
                                        "intensity": "NORM",
                                        "protection": "PROT",
                                    }
                                },
                                {
                                    "type": "simple",
                                    "id": "status",
                                    "data": status,
                                    "attributes": {
                                        "intensity": "HIGH",
                                        "protection": "PROT",
                                        "color": "white"
                                    }
                                }
                            ],
                            "actionKeys": [],
                            "functionKeys": [],
                            "helpMetaData": [],
                            "screenHelp": {},
                            "errSfl": false,
                            "positionLeft": 8,
                            "positionTop": 5,
                            "cursorPosition": false,
                            "height": 6.8,
                            "width": 65,
                            "messageLine": false,
                            "userRestoreDisplay": false,
                            "border": false,
                            "remove": false,
                            "borderColor": "black"
                        }
                    ]
                }
            ],
            "serverDescription": "",
            "terminalId": ""
        }
    }
}
