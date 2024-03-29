import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {PaiementAchatCriteria} from './PaiementAchatCriteria.model';
import {AchatItemCriteria} from './AchatItemCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';

export class AchatCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateAchat: Date;
    public dateAchatFrom: Date;
    public dateAchatTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaye: number;
     public totalPayeMin: number;
     public totalPayeMax: number;
    public description: string;
    public descriptionLike: string;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
      public paiementAchats: Array<PaiementAchatCriteria>;
      public achatItems: Array<AchatItemCriteria>;

}
