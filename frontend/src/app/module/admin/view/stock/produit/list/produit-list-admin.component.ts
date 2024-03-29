import {Component, OnInit} from '@angular/core';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/stock/ProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CategorieProduitDto} from 'src/app/controller/model/stock/CategorieProduit.model';
import {CategorieProduitAdminService} from 'src/app/controller/service/admin/stock/CategorieProduitAdmin.service';


@Component({
  selector: 'app-produit-list-admin',
  templateUrl: './produit-list-admin.component.html'
})
export class ProduitListAdminComponent extends AbstractListController<ProduitDto, ProduitCriteria, ProduitAdminService>  implements OnInit {

    fileName = 'Produit';

    categorieProduits: Array<CategorieProduitDto>;


    constructor( private produitService: ProduitAdminService  , private categorieProduitService: CategorieProduitAdminService) {
        super(produitService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadCategorieProduit();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'barcode', header: 'Barcode'},
            {field: 'discription', header: 'Discription'},
            {field: 'prixAchatMoyen', header: 'Prix achat moyen'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'seuilAlert', header: 'Seuil alert'},
            {field: 'categorieProduit?.reference', header: 'Categorie produit'},
        ];
    }


    public async loadCategorieProduit(){
       this.categorieProduitService.findAllOptimized().subscribe(categorieProduits => this.categorieProduits = categorieProduits, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Libelle': e.libelle ,
                 'Barcode': e.barcode ,
                 'Discription': e.discription ,
                 'Prix achat moyen': e.prixAchatMoyen ,
                 'Quantite': e.quantite ,
                 'Seuil alert': e.seuilAlert ,
                'Categorie produit': e.categorieProduit?.reference ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Barcode': this.criteria.barcode ? this.criteria.barcode : environment.emptyForExport ,
            'Discription': this.criteria.discription ? this.criteria.discription : environment.emptyForExport ,
            'Prix achat moyen Min': this.criteria.prixAchatMoyenMin ? this.criteria.prixAchatMoyenMin : environment.emptyForExport ,
            'Prix achat moyen Max': this.criteria.prixAchatMoyenMax ? this.criteria.prixAchatMoyenMax : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
            'Seuil alert Min': this.criteria.seuilAlertMin ? this.criteria.seuilAlertMin : environment.emptyForExport ,
            'Seuil alert Max': this.criteria.seuilAlertMax ? this.criteria.seuilAlertMax : environment.emptyForExport ,
        //'Categorie produit': this.criteria.categorieProduit?.reference ? this.criteria.categorieProduit?.reference : environment.emptyForExport ,
        }];
      }
}
