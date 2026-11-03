import { Component } from '@angular/core';
import { Window } from "../commonMap/window";
import { LanguageService } from '../../language/language-service';
import { TermState } from '../../models/term-state.model';

@Component({
    selector: 'display-queue-details',
    standalone: false,
    templateUrl: './display-queue-details.component.html'
})
export class DisplayQueueDetailsSubComponent extends Window {
    queueName: any = {};
    library: any = {};
    delivery: any = {};
    program: any = {};
    allowReply: any = {};
    severity: any = {};
    allowAlerts: any = {};
    ccsid: any = {};
    msgqfull: any = {};
    force: any = {};
    description: any = {};

    public FIELDS: string[] = ['queueName', 'library', 'delivery', 'program', 'allowReply', 'severity', 'allowAlerts', 'ccsid', 'msgqfull', 'force', 'description'];

    constructor(public languageService: LanguageService, public termState: TermState) {
        super();
    }
}
