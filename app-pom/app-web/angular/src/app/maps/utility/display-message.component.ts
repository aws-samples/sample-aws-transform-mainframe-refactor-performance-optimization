import { Component, ViewChild, DoCheck, OnDestroy, ChangeDetectorRef, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Overlay } from "../commonMap/overlay";
import { Data } from '../../term/term.model';
import { Paging, TableComponent } from '../../table/table.component';

@Component({
    selector: 'display-message',
    standalone: false,
    templateUrl: './display-message.component.html',
    styles: [`
        :host ::ng-deep .display-message-clfail-white input[type="text"] { color: var(--white) !important; }
    `]
})
export class DisplayMessageComponent extends Overlay implements DoCheck, OnDestroy {
    // List items
    msgs: any[] = [];

    // Header fields
    queue: Data = new Data();
    library1: Data = new Data();
    severity: Data = new Data();
    system: Data = new Data();
    program: Data = new Data();
    library2: Data = new Data();
    delivery: Data = new Data();

    // Primary function key labels
    labelF3Exit: Data = new Data('F3=Exit');
    labelF11RemoveMessage: Data = new Data('F11=Remove a message');
    labelF12Cancel: Data = new Data('F12=Cancel');
    labelF13RemoveAll: Data = new Data('F13=Remove all');
    labelF16RemoveAllExceptUnanswered: Data = new Data('F16=Remove all except unanswered');
    labelF24MoreKeys1: Data = new Data('F24=More keys');

    // Secondary function key labels
    labelF10DisplayAll: Data = new Data('F10=Display all');
    labelF22DisplayDetails: Data = new Data('F22=Display list details');
    labelF24MoreKeys2: Data = new Data('F24=More keys');

    // Error message
    clfail: Data = new Data();

    public isSubfileControl: boolean = true;
    public pagingMode: number = Paging.File;
    @ViewChild('table') subfileTable: TableComponent;

    private document: Document;

    constructor(
        @Inject(DOCUMENT) document: Document,
        private cdr: ChangeDetectorRef,
    ) {
        super();
        this.document = document;
    }

    /** Track last clicked row so F10 knows which message to reposition to */
    public lastClickedRow: number = -1;

    /** Track last clicked message's DB msgId (stable identifier across pagination/reorder) */
    public lastClickedMsgId: number = -1;

    public onRowClick(rowIndex: number, msgId?: number): void {
        this.lastClickedRow = rowIndex;
        if (typeof msgId === 'number' && msgId > 0) this.lastClickedMsgId = msgId;
    }

    /** Click delegation: finds the nearest ancestor with data-row-index */
    public onTableClick(event: MouseEvent): void {
        let el = event.target as HTMLElement | null;
        while (el && !el.hasAttribute('data-row-index')) {
            el = el.parentElement;
        }
        if (el) {
            const idx = Number(el.getAttribute('data-row-index'));
            const msgIdAttr = el.getAttribute('data-msg-id');
            const msgId = msgIdAttr ? Number(msgIdAttr) : undefined;
            if (!isNaN(idx)) {
                this.onRowClick(idx, msgId);
            }
        }
    }

    public FIELDS: string[] = [
        'queue', 'library1', 'severity', 'system', 'program',
        'library2', 'delivery', 'fromuser', 'msgdate', 'msgtime',
        'reply',
        'labelF3Exit', 'labelF11RemoveMessage', 'labelF12Cancel',
        'labelF13RemoveAll', 'labelF16RemoveAllExceptUnanswered', 'labelF24MoreKeys1',
        'labelF10DisplayAll', 'labelF22DisplayDetails',
        'labelF24MoreKeys2', 'clfail'
    ];

    ngAfterViewInit(): void {
        // Listen for the app-table's afterPaging event to show "Already at top/bottom" messages
        this.document.addEventListener('afterPaging', this._afterPagingHandler);
    }

    ngOnDestroy(): void {
        this.document.removeEventListener('afterPaging', this._afterPagingHandler);
    }

    private _afterPagingHandler = (evt: Event): void => {
        const custom = evt as CustomEvent;
        const pagingResult = custom.detail?.pagingResult;  // false = at boundary (not handled)
        const keyEvent = custom.detail?.event as KeyboardEvent;
        if (!pagingResult && keyEvent) {
            if (keyEvent.key === 'PageDown') {
                this.clfail.value = 'Already at bottom of area.';
            } else if (keyEvent.key === 'PageUp') {
                this.clfail.value = 'Already at top of area.';
            }
        } else {
            this.clfail.value = '';
        }
        this.cdr.detectChanges();
    };

    private lastMsgsLength: number = 0;
    private lastRecordNumber: number = -1;

    ngDoCheck(): void {
        if (!this.msgs || !this.subfileTable) return;

        const currentRecordNumber = (this.msgs as any).attributes?.recordNumber;
        const lengthChanged = this.msgs.length !== this.lastMsgsLength;
        const recordNumberChanged = currentRecordNumber !== undefined && currentRecordNumber !== this.lastRecordNumber;

        // Re-initialize the table when the array is mutated in place, or when the backend updates the scroll position
        if (lengthChanged || recordNumberChanged) {
            this.lastMsgsLength = this.msgs.length;
            if (currentRecordNumber !== undefined) this.lastRecordNumber = currentRecordNumber;
            // Create new reference to force initRows recalculation
            const newRows = Object.assign([], this.msgs);
            Object.keys(this.msgs).forEach(key => {
                if (isNaN(Number(key))) newRows[key] = this.msgs[key];
            });
            this.subfileTable.rows = newRows;
            // Apply recordNumber (backend-driven scroll position) if present
            if (currentRecordNumber !== undefined && currentRecordNumber > 0) {
                this.subfileTable.setRecordNumber(currentRecordNumber - 1);
            }
        }
    }

    displaySfl() {
        return "lgr_col";
    }

    public doPaging(key: KeyboardEvent): boolean {
        if (!this.subfileTable) return true;
        const wasAtBottom = this.subfileTable.isAtBottom();
        const wasAtTop = (this.subfileTable as any).recordNumber === 0;
        const result = this.subfileTable.keyEvent(key);

        // If at boundary, show message and consume the key (return false = handled)
        if (result === true) {
            if (key.key === 'PageDown' && wasAtBottom) {
                this._setClfail('Already at bottom of area.');
                return false;
            } else if (key.key === 'PageUp' && wasAtTop) {
                this._setClfail('Already at top of area.');
                return false;
            }
        } else {
            this._setClfail('');
        }
        return result;
    }

    /** Update clfail value AND viewData so dynamic-field re-renders */
    private _setClfail(msg: string): void {
        this.clfail.value = msg;
        if (this.clfail.viewData) {
            this.clfail.viewData.value = msg;
        }
        this.cdr.detectChanges();
    }

    /** Client-side F10 reposition — scroll to the start of the message containing the clicked row */
    public repositionToClickedRow(): boolean {
        if (!this.subfileTable || this.lastClickedRow < 0 || !this.msgs) {
            return false;
        }
        // Walk backward from the clicked row to find the start of the message (line with "From  . . . :")
        let startRow = this.lastClickedRow;
        while (startRow > 0) {
            const row: any = this.msgs[startRow];
            const text = row?.msgtext?.value || '';
            if (text.startsWith('From  . . . :')) break;
            startRow--;
        }
        this.subfileTable.setRecordNumber(startRow);
        this.clfail.value = '';
        return true;
    }

    public doDropFold(key: KeyboardEvent): boolean {
        return false;
    }

    public updateSubfile(): boolean {
        return false;
    }

    public clearSubfile(): void {
        if (this.subfileTable !== undefined) {
            this.subfileTable.rows = [];
        }
        this.msgs = [];
    }
}
