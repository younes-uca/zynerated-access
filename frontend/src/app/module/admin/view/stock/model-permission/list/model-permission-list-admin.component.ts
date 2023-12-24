import {Component, OnInit} from '@angular/core';
import {ModelPermissionAdminService} from 'src/app/controller/service/admin/stock/ModelPermissionAdmin.service';
import {ModelPermissionDto} from 'src/app/controller/model/stock/ModelPermission.model';
import {ModelPermissionCriteria} from 'src/app/controller/criteria/stock/ModelPermissionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-model-permission-list-admin',
  templateUrl: './model-permission-list-admin.component.html'
})
export class ModelPermissionListAdminComponent extends AbstractListController<ModelPermissionDto, ModelPermissionCriteria, ModelPermissionAdminService>  implements OnInit {

    fileName = 'ModelPermission';



    constructor( private modelPermissionService: ModelPermissionAdminService  ) {
        super(modelPermissionService);
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
