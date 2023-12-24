import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CategorieProduitAdminService} from 'src/app/controller/service/admin/stock/CategorieProduitAdmin.service';
import {CategorieProduitDto} from 'src/app/controller/model/stock/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/controller/criteria/stock/CategorieProduitCriteria.model';



@Component({
  selector: 'app-categorie-produit-edit-admin',
  templateUrl: './categorie-produit-edit-admin.component.html'
})
export class CategorieProduitEditAdminComponent extends AbstractEditController<CategorieProduitDto, CategorieProduitCriteria, CategorieProduitAdminService>   implements OnInit {


    private _validCategorieProduitReference = true;




    constructor( private categorieProduitService: CategorieProduitAdminService ) {
        super(categorieProduitService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validCategorieProduitReference = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategorieProduitReference();
    }
    public validateCategorieProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validCategorieProduitReference = false;
        } else {
            this.validCategorieProduitReference = true;
        }
    }






    get validCategorieProduitReference(): boolean {
        return this._validCategorieProduitReference;
    }
    set validCategorieProduitReference(value: boolean) {
        this._validCategorieProduitReference = value;
    }

}
