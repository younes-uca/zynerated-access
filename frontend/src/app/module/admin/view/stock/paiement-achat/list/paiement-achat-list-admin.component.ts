import {Component, OnInit} from '@angular/core';
import {PaiementAchatAdminService} from 'src/app/controller/service/admin/stock/PaiementAchatAdmin.service';
import {PaiementAchatDto} from 'src/app/controller/model/stock/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/stock/PaiementAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';


@Component({
  selector: 'app-paiement-achat-list-admin',
  templateUrl: './paiement-achat-list-admin.component.html'
})
export class PaiementAchatListAdminComponent extends AbstractListController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatAdminService>  implements OnInit {

    fileName = 'PaiementAchat';

    achats: Array<AchatDto>;


    constructor( private paiementAchatService: PaiementAchatAdminService  , private achatService: AchatAdminService) {
        super(paiementAchatService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadAchat();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'achat?.reference', header: 'Achat'},
        ];
    }


    public async loadAchat(){
       this.achatService.findAllOptimized().subscribe(achats => this.achats = achats, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Achat': e.achat?.reference ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Achat': this.criteria.achat?.reference ? this.criteria.achat?.reference : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
