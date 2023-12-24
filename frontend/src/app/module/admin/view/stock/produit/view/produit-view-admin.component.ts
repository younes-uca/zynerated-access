import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/stock/ProduitCriteria.model';

import {CategorieProduitDto} from 'src/app/controller/model/stock/CategorieProduit.model';
import {CategorieProduitAdminService} from 'src/app/controller/service/admin/stock/CategorieProduitAdmin.service';
@Component({
  selector: 'app-produit-view-admin',
  templateUrl: './produit-view-admin.component.html'
})
export class ProduitViewAdminComponent extends AbstractViewController<ProduitDto, ProduitCriteria, ProduitAdminService> implements OnInit {


    constructor(private produitService: ProduitAdminService, private categorieProduitService: CategorieProduitAdminService){
        super(produitService);
    }

    ngOnInit(): void {
    }


    get categorieProduit(): CategorieProduitDto {
       return this.categorieProduitService.item;
    }
    set categorieProduit(value: CategorieProduitDto) {
        this.categorieProduitService.item = value;
    }
    get categorieProduits(): Array<CategorieProduitDto> {
       return this.categorieProduitService.items;
    }
    set categorieProduits(value: Array<CategorieProduitDto>) {
        this.categorieProduitService.items = value;
    }


}
