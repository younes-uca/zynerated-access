import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ModelPermissionAdminService} from 'src/app/controller/service/admin/stock/ModelPermissionAdmin.service';
import {ModelPermissionDto} from 'src/app/controller/model/stock/ModelPermission.model';
import {ModelPermissionCriteria} from 'src/app/controller/criteria/stock/ModelPermissionCriteria.model';



@Component({
  selector: 'app-model-permission-edit-admin',
  templateUrl: './model-permission-edit-admin.component.html'
})
export class ModelPermissionEditAdminComponent extends AbstractEditController<ModelPermissionDto, ModelPermissionCriteria, ModelPermissionAdminService>   implements OnInit {


    private _validModelPermissionReference = true;




    constructor( private modelPermissionService: ModelPermissionAdminService ) {
        super(modelPermissionService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validModelPermissionReference = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateModelPermissionReference();
    }
    public validateModelPermissionReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validModelPermissionReference = false;
        } else {
            this.validModelPermissionReference = true;
        }
    }






    get validModelPermissionReference(): boolean {
        return this._validModelPermissionReference;
    }
    set validModelPermissionReference(value: boolean) {
        this._validModelPermissionReference = value;
    }

}
