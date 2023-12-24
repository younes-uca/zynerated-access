import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/stock/ProduitCriteria.model';
import {CategorieProduitDto} from 'src/app/controller/model/stock/CategorieProduit.model';
import {CategorieProduitAdminService} from 'src/app/controller/service/admin/stock/CategorieProduitAdmin.service';
@Component({
  selector: 'app-produit-create-admin',
  templateUrl: './produit-create-admin.component.html'
})
export class ProduitCreateAdminComponent extends AbstractCreateController<ProduitDto, ProduitCriteria, ProduitAdminService>  implements OnInit {



   private _validProduitReference = true;
    private _validCategorieProduitReference = true;

    constructor( private produitService: ProduitAdminService , private categorieProduitService: CategorieProduitAdminService) {
        super(produitService);
    }

    ngOnInit(): void {
        this.categorieProduit = new CategorieProduitDto();
        this.categorieProduitService.findAll().subscribe((data) => this.categorieProduits = data);
    }





    public setValidation(value: boolean){
        this.validProduitReference = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProduitReference();
    }

    public validateProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validProduitReference = false;
        } else {
            this.validProduitReference = true;
        }
    }


    public async openCreateCategorieProduit(categorieProduit: string) {
    const isPermistted = await this.roleService.isPermitted('CategorieProduit', 'add');
    if(isPermistted) {
         this.categorieProduit = new CategorieProduitDto();
         this.createCategorieProduitDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createCategorieProduitDialog(): boolean {
       return this.categorieProduitService.createDialog;
    }
    set createCategorieProduitDialog(value: boolean) {
        this.categorieProduitService.createDialog= value;
    }



    get validProduitReference(): boolean {
        return this._validProduitReference;
    }

    set validProduitReference(value: boolean) {
         this._validProduitReference = value;
    }

    get validCategorieProduitReference(): boolean {
        return this._validCategorieProduitReference;
    }
    set validCategorieProduitReference(value: boolean) {
        this._validCategorieProduitReference = value;
    }


}
