import { TermModalService } from './term-modal.service';
import { TokenField } from '../term/term.model';

/**
 * Inherits this class for modal component relative to transaction in term.
 */
export abstract class AbstractTermModal {
    /* FIELDS ============================================================== */
    modalId: string;
    private _resolve: (value:TokenField[]) => any;

    /* CONSTRUCTORS ======================================================== */
    constructor( modalId: string, service: TermModalService ) {
        this.modalId = modalId;
        service.register( modalId, this );
    }

    /* METHODS ============================================================= */
    protected get resolve(): (value:TokenField[]) => any {
        return this._resolve;
    }

    public show(): Promise<TokenField[]> {
        return new Promise<TokenField[]>( resolve => {
            this.showModal();
            this._resolve = resolve
        } );
    }

    /* Bootstrap - Modal --------------------------------------------------- */
    protected showModal(): void {
        this.modal( 'block' );
    }

    protected hideModal(): void {
        this.modal( 'none' );
    }

    private modal(action: string): void {
        setTimeout( () => document.getElementById(this.modalId).style.display = action, 50 );
    }
}
