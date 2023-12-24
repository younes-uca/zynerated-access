import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PermissionAdminService} from 'src/app/controller/service/admin/stock/PermissionAdmin.service';
import {PermissionDto} from 'src/app/controller/model/stock/Permission.model';
import {PermissionCriteria} from 'src/app/controller/criteria/stock/PermissionCriteria.model';
import {ActionPermissionDto} from 'src/app/controller/model/stock/ActionPermission.model';
import {ActionPermissionAdminService} from 'src/app/controller/service/admin/stock/ActionPermissionAdmin.service';
import {ModelPermissionDto} from 'src/app/controller/model/stock/ModelPermission.model';
import {ModelPermissionAdminService} from 'src/app/controller/service/admin/stock/ModelPermissionAdmin.service';
@Component({
  selector: 'app-permission-create-admin',
  templateUrl: './permission-create-admin.component.html'
})
export class PermissionCreateAdminComponent extends AbstractCreateController<PermissionDto, PermissionCriteria, PermissionAdminService>  implements OnInit {



    private _validActionPermissionReference = true;
    private _validModelPermissionReference = true;

    constructor( private permissionService: PermissionAdminService , private actionPermissionService: ActionPermissionAdminService, private modelPermissionService: ModelPermissionAdminService) {
        super(permissionService);
    }

    ngOnInit(): void {
        this.actionPermission = new ActionPermissionDto();
        this.actionPermissionService.findAll().subscribe((data) => this.actionPermissions = data);
        this.modelPermission = new ModelPermissionDto();
        this.modelPermissionService.findAll().subscribe((data) => this.modelPermissions = data);
    }





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateModelPermission(modelPermission: string) {
    const isPermistted = await this.roleService.isPermitted('ModelPermission', 'add');
    if(isPermistted) {
         this.modelPermission = new ModelPermissionDto();
         this.createModelPermissionDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateActionPermission(actionPermission: string) {
    const isPermistted = await this.roleService.isPermitted('ActionPermission', 'add');
    if(isPermistted) {
         this.actionPermission = new ActionPermissionDto();
         this.createActionPermissionDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get modelPermission(): ModelPermissionDto {
        return this.modelPermissionService.item;
    }
    set modelPermission(value: ModelPermissionDto) {
        this.modelPermissionService.item = value;
    }
    get modelPermissions(): Array<ModelPermissionDto> {
        return this.modelPermissionService.items;
    }
    set modelPermissions(value: Array<ModelPermissionDto>) {
        this.modelPermissionService.items = value;
    }
    get createModelPermissionDialog(): boolean {
       return this.modelPermissionService.createDialog;
    }
    set createModelPermissionDialog(value: boolean) {
        this.modelPermissionService.createDialog= value;
    }
    get actionPermission(): ActionPermissionDto {
        return this.actionPermissionService.item;
    }
    set actionPermission(value: ActionPermissionDto) {
        this.actionPermissionService.item = value;
    }
    get actionPermissions(): Array<ActionPermissionDto> {
        return this.actionPermissionService.items;
    }
    set actionPermissions(value: Array<ActionPermissionDto>) {
        this.actionPermissionService.items = value;
    }
    get createActionPermissionDialog(): boolean {
       return this.actionPermissionService.createDialog;
    }
    set createActionPermissionDialog(value: boolean) {
        this.actionPermissionService.createDialog= value;
    }




    get validActionPermissionReference(): boolean {
        return this._validActionPermissionReference;
    }
    set validActionPermissionReference(value: boolean) {
        this._validActionPermissionReference = value;
    }
    get validModelPermissionReference(): boolean {
        return this._validModelPermissionReference;
    }
    set validModelPermissionReference(value: boolean) {
        this._validModelPermissionReference = value;
    }


}
