import {Component, OnInit} from '@angular/core';
import {ActionPermissionAdminService} from 'src/app/controller/service/admin/stock/ActionPermissionAdmin.service';
import {ActionPermissionDto} from 'src/app/controller/model/stock/ActionPermission.model';
import {ActionPermissionCriteria} from 'src/app/controller/criteria/stock/ActionPermissionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-action-permission-list-admin',
  templateUrl: './action-permission-list-admin.component.html'
})
export class ActionPermissionListAdminComponent extends AbstractListController<ActionPermissionDto, ActionPermissionCriteria, ActionPermissionAdminService>  implements OnInit {

    fileName = 'ActionPermission';



    constructor( private actionPermissionService: ActionPermissionAdminService  ) {
        super(actionPermissionService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
