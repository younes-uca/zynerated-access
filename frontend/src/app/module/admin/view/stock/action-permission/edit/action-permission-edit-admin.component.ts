import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ActionPermissionAdminService} from 'src/app/controller/service/admin/stock/ActionPermissionAdmin.service';
import {ActionPermissionDto} from 'src/app/controller/model/stock/ActionPermission.model';
import {ActionPermissionCriteria} from 'src/app/controller/criteria/stock/ActionPermissionCriteria.model';



@Component({
  selector: 'app-action-permission-edit-admin',
  templateUrl: './action-permission-edit-admin.component.html'
})
export class ActionPermissionEditAdminComponent extends AbstractEditController<ActionPermissionDto, ActionPermissionCriteria, ActionPermissionAdminService>   implements OnInit {


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
