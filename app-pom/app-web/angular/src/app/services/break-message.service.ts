import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class BreakMessageService {

    public message: string = '';
    public visible: boolean = false;

    show(message: string) {
        this.message = message;
        this.visible = true;
    }

    clear() {
        this.message = '';
        this.visible = false;
    }
}
