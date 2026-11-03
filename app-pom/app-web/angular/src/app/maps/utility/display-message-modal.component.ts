import { Component } from '@angular/core';

@Component({
    selector: 'display-message-modal',
    standalone: false,
    template: '<modal-window class="modal-window" name="display-message"></modal-window>'
})
export class DisplayMessageModalComponent {
    public FIELDS: string[] = [];
}
