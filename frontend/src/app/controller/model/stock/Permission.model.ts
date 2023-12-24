import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ActionPermissionDto} from './ActionPermission.model';
import {ModelPermissionDto} from './ModelPermission.model';

export class PermissionDto extends BaseDto{

    public subAttribute: string;

   public value: null | boolean;

    public actionPermission: ActionPermissionDto ;
    public modelPermission: ModelPermissionDto ;
    

    constructor() {
        super();

        this.subAttribute = '';
        this.value = null;
        this.actionPermission = new ActionPermissionDto() ;
        this.modelPermission = new ModelPermissionDto() ;

        }

}
