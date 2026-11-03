import { NgZone, inject } from '@angular/core';
import { take } from 'rxjs/operators';

export class Overlay {

    public overlay?: boolean = false;
    public startLineNumber? = 0;
    public transparent?: boolean = false;
    public overlappingFieldLines: number[] = [];
    protected ngZone = inject(NgZone);

    mapDivStyle() {

        const lineHeightVal = +document.documentElement.style.getPropertyValue('--line_height').replace('em', '');
        // lrg height css
        let height: number = lineHeightVal === 0 ? 1.4 : lineHeightVal;
        let style = "{";

        if(this.overlay !== undefined) {
            if (this.overlay) {
                style += '"position":"absolute"';
                if (this.startLineNumber == 0) {
                    style += ',"top": "0em"';
                } else {
                    style += ',"top": "' + ((this.startLineNumber-1) * height) + 'em"';
                }
            } else {
                style += '"position":"static"';
            }
        }

        if(this.transparent !== undefined) {
            if (this.transparent) {
                style += ',"opacity":0';
            } else {
                style += ',"opacity":1';
            }
        }
        
        style += "}";

        return JSON.parse(style);
    }
    
    /**
     * Checks for overlapping fields on lines specified in overlappingFieldLines and hides the overlapped fields accordingly.
     * 
     * @param component 
     */
    checkOverlappingFields(component: string) {
        this.ngZone.onStable.pipe(take(1)).subscribe(() => {
        	// Get all lines with possible overlap belonging to this particular component.
            document.querySelectorAll(`${component} .lgr_col`).forEach((container, groupIndex) => {
                if (!this.overlappingFieldLines.includes(groupIndex + 1)) return;
                
                let currentPosition = 0;
                // Go through each field on the line.
                container.querySelectorAll('div:not(.hidden)[class*="lgr_"][class*="col_"]').forEach(div => {
                    const lgr = +(div.className.match(/lgr_(\d+)/)?.[1]);
                    const col = +(div.className.match(/col_(\d+)/)?.[1]);

                    // Based on calculated position, hide if current field overlaps with previous.
                    if (col <= currentPosition) {
                        div.classList.add('hidden');
                    } else {
                        currentPosition = lgr + col;
                    }
                });
            });
        });
    }
}


