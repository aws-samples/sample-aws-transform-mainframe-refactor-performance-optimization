import { Component } from '@angular/core';
import { BreakMessageService } from '../../services/break-message.service';

@Component({
    selector: 'break-message-toast',
    standalone: false,
    templateUrl: './break-message.component.html'
})
export class BreakMessageComponent {

    constructor(public breakMessageService: BreakMessageService) {}

    dismiss() {
        this.breakMessageService.clear();
    }
}
