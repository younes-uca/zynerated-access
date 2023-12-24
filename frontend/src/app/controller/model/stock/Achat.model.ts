import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PaiementAchatDto} from './PaiementAchat.model';
import {AchatItemDto} from './AchatItem.model';
import {ClientDto} from './Client.model';

export class AchatDto extends BaseDto{

    public reference: string;

   public dateAchat: Date;

    public total: null | number;

    public totalPaye: null | number;

    public description: string;

    public client: ClientDto ;
     public paiementAchats: Array<PaiementAchatDto>;
     public achatItems: Array<AchatItemDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.dateAchat = null;
        this.total = null;
        this.totalPaye = null;
        this.description = '';
        this.client = new ClientDto() ;
        this.paiementAchats = new Array<PaiementAchatDto>();
        this.achatItems = new Array<AchatItemDto>();

        }

}
