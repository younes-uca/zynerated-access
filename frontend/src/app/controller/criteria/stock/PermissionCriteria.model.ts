import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ActionPermissionCriteria} from './ActionPermissionCriteria.model';
import {ModelPermissionCriteria} from './ModelPermissionCriteria.model';

export class PermissionCriteria  extends BaseCriteria  {

    public id: number;
    public subAttribute: string;
    public subAttributeLike: string;
    public value: null | boolean;
  public actionPermission: ActionPermissionCriteria ;
  public actionPermissions: Array<ActionPermissionCriteria> ;
  public modelPermission: ModelPermissionCriteria ;
  public modelPermissions: Array<ModelPermissionCriteria> ;

}
