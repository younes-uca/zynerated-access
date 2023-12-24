import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ActionPermissionAdminService} from 'src/app/controller/service/admin/stock/ActionPermissionAdmin.service';
import {ActionPermissionDto} from 'src/app/controller/model/stock/ActionPermission.model';
import {ActionPermissionCriteria} from 'src/app/controller/criteria/stock/ActionPermissionCriteria.model';
@Component({
  selector: 'app-action-permission-create-admin',
  templateUrl: './action-permission-create-admin.component.html'
})
export class ActionPermissionCreateAdminComponent extends AbstractCreateController<ActionPermissionDto, ActionPermissionCriteria, ActionPermissionAdminService>  implements OnInit {



   private _validActionPermissionReference = true;

    constructor( private actionPermissionService: ActionPermissionAdminService ) {
        super(actionPermissionService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validActionPermissionReference = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateActionPermissionReference();
    }

    public validateActionPermissionReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validActionPermissionReference = false;
        } else {
            this.validActionPermissionReference = true;
        }
    }






    get validActionPermissionReference(): boolean {
        return this._validActionPermissionReference;
    }

    set validActionPermissionReference(value: boolean) {
         this._validActionPermissionReference = value;
    }



}
