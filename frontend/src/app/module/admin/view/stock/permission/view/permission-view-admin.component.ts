import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PermissionAdminService} from 'src/app/controller/service/admin/stock/PermissionAdmin.service';
import {PermissionDto} from 'src/app/controller/model/stock/Permission.model';
import {PermissionCriteria} from 'src/app/controller/criteria/stock/PermissionCriteria.model';

import {ActionPermissionDto} from 'src/app/controller/model/stock/ActionPermission.model';
import {ActionPermissionAdminService} from 'src/app/controller/service/admin/stock/ActionPermissionAdmin.service';
import {ModelPermissionDto} from 'src/app/controller/model/stock/ModelPermission.model';
import {ModelPermissionAdminService} from 'src/app/controller/service/admin/stock/ModelPermissionAdmin.service';
@Component({
  selector: 'app-permission-view-admin',
  templateUrl: './permission-view-admin.component.html'
})
export class PermissionViewAdminComponent extends AbstractViewController<PermissionDto, PermissionCriteria, PermissionAdminService> implements OnInit {


    constructor(private permissionService: PermissionAdminService, private actionPermissionService: ActionPermissionAdminService, private modelPermissionService: ModelPermissionAdminService){
        super(permissionService);
    }

    ngOnInit(): void {
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


}
