import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ModelPermissionAdminService} from 'src/app/controller/service/admin/stock/ModelPermissionAdmin.service';
import {ModelPermissionDto} from 'src/app/controller/model/stock/ModelPermission.model';
import {ModelPermissionCriteria} from 'src/app/controller/criteria/stock/ModelPermissionCriteria.model';

@Component({
  selector: 'app-model-permission-view-admin',
  templateUrl: './model-permission-view-admin.component.html'
})
export class ModelPermissionViewAdminComponent extends AbstractViewController<ModelPermissionDto, ModelPermissionCriteria, ModelPermissionAdminService> implements OnInit {


    constructor(private modelPermissionService: ModelPermissionAdminService){
        super(modelPermissionService);
    }

    ngOnInit(): void {
    }




}
