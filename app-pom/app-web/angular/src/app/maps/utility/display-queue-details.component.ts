import { Component } from '@angular/core';

@Component({
    selector: 'display-queue-details',
    standalone: false,
    template: '<modal-window class="modal-window" name="display-queue-details"></modal-window>'
})
export class DisplayQueueDetailsComponent {
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
}
