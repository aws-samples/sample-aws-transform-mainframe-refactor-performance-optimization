import { AfterContentChecked, Component, Input } from '@angular/core';
import { Overlay } from "../commonMap/overlay";
import { Data } from '../../term/term.model';

@Component({
    selector: 'display-message-msg',
    standalone: false,
    templateUrl: './display-message-msg.component.html'
})
export class DisplayMessageMsgComponent extends Overlay implements AfterContentChecked {
    @Input() msg;
    @Input() index: number;

    msgtext: Data = new Data();

    public FIELDS: string[] = [
        'msgtext'
    ];

    ngAfterContentChecked(): void {
        this.msgtext = this.msg?.msgtext ?? '';
    }

    positionSFL(): string {
        return "lgr_col";
    }
}
