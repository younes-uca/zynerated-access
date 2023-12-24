import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategorieProduitAdminService} from 'src/app/controller/service/admin/stock/CategorieProduitAdmin.service';
import {CategorieProduitDto} from 'src/app/controller/model/stock/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/controller/criteria/stock/CategorieProduitCriteria.model';

@Component({
  selector: 'app-categorie-produit-view-admin',
  templateUrl: './categorie-produit-view-admin.component.html'
})
export class CategorieProduitViewAdminComponent extends AbstractViewController<CategorieProduitDto, CategorieProduitCriteria, CategorieProduitAdminService> implements OnInit {


    constructor(private categorieProduitService: CategorieProduitAdminService){
        super(categorieProduitService);
    }

    ngOnInit(): void {
    }




}
