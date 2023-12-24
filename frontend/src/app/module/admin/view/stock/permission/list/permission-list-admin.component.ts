import {Component, OnInit} from '@angular/core';
import {PermissionAdminService} from 'src/app/controller/service/admin/stock/PermissionAdmin.service';
import {PermissionDto} from 'src/app/controller/model/stock/Permission.model';
import {PermissionCriteria} from 'src/app/controller/criteria/stock/PermissionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ActionPermissionDto} from 'src/app/controller/model/stock/ActionPermission.model';
import {ActionPermissionAdminService} from 'src/app/controller/service/admin/stock/ActionPermissionAdmin.service';
import {ModelPermissionDto} from 'src/app/controller/model/stock/ModelPermission.model';
import {ModelPermissionAdminService} from 'src/app/controller/service/admin/stock/ModelPermissionAdmin.service';


@Component({
  selector: 'app-permission-list-admin',
  templateUrl: './permission-list-admin.component.html'
})
export class PermissionListAdminComponent extends AbstractListController<PermissionDto, PermissionCriteria, PermissionAdminService>  implements OnInit {

    fileName = 'Permission';

     yesOrNoValue: any[] = [];
    actionPermissions: Array<ActionPermissionDto>;
    modelPermissions: Array<ModelPermissionDto>;


    constructor( private permissionService: PermissionAdminService  , private actionPermissionService: ActionPermissionAdminService, private modelPermissionService: ModelPermissionAdminService) {
        super(permissionService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadActionPermission();
        this.loadModelPermission();
        this.yesOrNoValue =  [{label: 'Value', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }


    public initCol() {
        this.cols = [
            {field: 'actionPermission?.reference', header: 'Action permission'},
            {field: 'modelPermission?.reference', header: 'Model permission'},
            {field: 'subAttribute', header: 'Sub attribute'},
            {field: 'value', header: 'Value'},
        ];
    }


    public async loadActionPermission(){
       this.actionPermissionService.findAllOptimized().subscribe(actionPermissions => this.actionPermissions = actionPermissions, error => console.log(error))
    }
    public async loadModelPermission(){
       this.modelPermissionService.findAllOptimized().subscribe(modelPermissions => this.modelPermissions = modelPermissions, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Action permission': e.actionPermission?.reference ,
                'Model permission': e.modelPermission?.reference ,
                 'Sub attribute': e.subAttribute ,
                'Value': e.value? 'Vrai' : 'Faux' ,
            }
        });

        this.criteriaData = [{
        //'Action permission': this.criteria.actionPermission?.reference ? this.criteria.actionPermission?.reference : environment.emptyForExport ,
        //'Model permission': this.criteria.modelPermission?.reference ? this.criteria.modelPermission?.reference : environment.emptyForExport ,
            'Sub attribute': this.criteria.subAttribute ? this.criteria.subAttribute : environment.emptyForExport ,
            'Value': this.criteria.value ? (this.criteria.value ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        }];
      }
}
