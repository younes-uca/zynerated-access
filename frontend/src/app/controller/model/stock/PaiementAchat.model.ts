import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AchatDto} from './Achat.model';

export class PaiementAchatDto extends BaseDto{

    public reference: string;

   public datePaiement: Date;

    public montant: null | number;

    public description: string;

    public achat: AchatDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.datePaiement = null;
        this.montant = null;
        this.description = '';
        this.achat = new AchatDto() ;

        }

}
