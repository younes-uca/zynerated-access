import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatCriteria} from 'src/app/controller/criteria/stock/AchatCriteria.model';


import {AchatItemDto} from 'src/app/controller/model/stock/AchatItem.model';
import {AchatItemAdminService} from 'src/app/controller/service/admin/stock/AchatItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {PaiementAchatDto} from 'src/app/controller/model/stock/PaiementAchat.model';
import {PaiementAchatAdminService} from 'src/app/controller/service/admin/stock/PaiementAchatAdmin.service';
import {ClientDto} from 'src/app/controller/model/stock/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/stock/ClientAdmin.service';

@Component({
  selector: 'app-achat-edit-admin',
  templateUrl: './achat-edit-admin.component.html'
})
export class AchatEditAdminComponent extends AbstractEditController<AchatDto, AchatCriteria, AchatAdminService>   implements OnInit {

    private _paiementAchatsElement = new PaiementAchatDto();
    private _achatItemsElement = new AchatItemDto();

    private _validAchatReference = true;

    private _validClientCin = true;
    private _validClientNom = true;
    private _validPaiementAchatsReference = true;
    private _validAchatItemsProduit = true;
    private _validAchatItemsPrixUnitaire = true;
    private _validAchatItemsPrixVente = true;
    private _validAchatItemsQuantite = true;



    constructor( private achatService: AchatAdminService , private paiementAchatService: PaiementAchatAdminService, private achatItemService: AchatItemAdminService, private clientService: ClientAdminService, private produitService: ProduitAdminService) {
        super(achatService);
    }

    ngOnInit(): void {

        this.achatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }
    public prepareEdit() {
        this.item.dateAchat = this.achatService.format(this.item.dateAchat);
    }



    public validatePaiementAchats(){
        this.errorMessages = new Array();
        this.validatePaiementAchatsReference();
    }
    public validateAchatItems(){
        this.errorMessages = new Array();
        this.validateAchatItemsProduit();
        this.validateAchatItemsPrixUnitaire();
        this.validateAchatItemsPrixVente();
        this.validateAchatItemsQuantite();
    }
    public setValidation(value: boolean){
        this.validAchatReference = value;
        this.validPaiementAchatsReference = value;
        this.validAchatItemsProduit = value;
        this.validAchatItemsPrixUnitaire = value;
        this.validAchatItemsPrixVente = value;
        this.validAchatItemsQuantite = value;
        }
   public addPaiementAchats() {
        if( this.item.paiementAchats == null )
            this.item.paiementAchats = new Array<PaiementAchatDto>();
       this.validatePaiementAchats();
       if (this.errorMessages.length === 0) {
            if(this.paiementAchatsElement.id == null){
                this.item.paiementAchats.push(this.paiementAchatsElement);
            }else{
                const index = this.item.paiementAchats.findIndex(e => e.id == this.paiementAchatsElement.id);
                this.item.paiementAchats[index] = this.paiementAchatsElement;
            }
          this.paiementAchatsElement = new PaiementAchatDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deletePaiementAchats(p: PaiementAchatDto) {
        this.item.paiementAchats.forEach((element, index) => {
            if (element === p) { this.item.paiementAchats.splice(index, 1); }
        });
    }

    public editPaiementAchats(p: PaiementAchatDto) {
        this.paiementAchatsElement = {... p};
        this.activeTab = 0;
    }
   public addAchatItems() {
        if( this.item.achatItems == null )
            this.item.achatItems = new Array<AchatItemDto>();
       this.validateAchatItems();
       if (this.errorMessages.length === 0) {
            if(this.achatItemsElement.id == null){
                this.item.achatItems.push(this.achatItemsElement);
            }else{
                const index = this.item.achatItems.findIndex(e => e.id == this.achatItemsElement.id);
                this.item.achatItems[index] = this.achatItemsElement;
            }
          this.achatItemsElement = new AchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAchatItems(p: AchatItemDto) {
        this.item.achatItems.forEach((element, index) => {
            if (element === p) { this.item.achatItems.splice(index, 1); }
        });
    }

    public editAchatItems(p: AchatItemDto) {
        this.achatItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAchatReference();
    }
    public validateAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validAchatReference = false;
        } else {
            this.validAchatReference = true;
        }
    }


    private validatePaiementAchatsReference(){
        if (this.paiementAchatsElement.reference == null) {
        this.errorMessages.push('Reference de la paiementAchat est  invalide');
            this.validPaiementAchatsReference = false;
        } else {
            this.validPaiementAchatsReference = true;
        }
    }
    private validateAchatItemsProduit(){
        if (this.achatItemsElement.produit == null) {
        this.errorMessages.push('Produit de la achatItem est  invalide');
            this.validAchatItemsProduit = false;
        } else {
            this.validAchatItemsProduit = true;
        }
    }
    private validateAchatItemsPrixUnitaire(){
        if (this.achatItemsElement.prixUnitaire == null) {
        this.errorMessages.push('PrixUnitaire de la achatItem est  invalide');
            this.validAchatItemsPrixUnitaire = false;
        } else {
            this.validAchatItemsPrixUnitaire = true;
        }
    }
    private validateAchatItemsPrixVente(){
        if (this.achatItemsElement.prixVente == null) {
        this.errorMessages.push('PrixVente de la achatItem est  invalide');
            this.validAchatItemsPrixVente = false;
        } else {
            this.validAchatItemsPrixVente = true;
        }
    }
    private validateAchatItemsQuantite(){
        if (this.achatItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la achatItem est  invalide');
            this.validAchatItemsQuantite = false;
        } else {
            this.validAchatItemsQuantite = true;
        }
    }

   public async openCreateProduit(produit: string) {
        const isPermistted = await this.roleService.isPermitted('Produit', 'edit');
        if (isPermistted) {
             this.produit = new ProduitDto();
             this.createProduitDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateClient(client: string) {
        const isPermistted = await this.roleService.isPermitted('Client', 'edit');
        if (isPermistted) {
             this.client = new ClientDto();
             this.createClientDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get client(): ClientDto {
       return this.clientService.item;
   }
  set client(value: ClientDto) {
        this.clientService.item = value;
   }
   get clients(): Array<ClientDto> {
        return this.clientService.items;
   }
   set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
   }
   get createClientDialog(): boolean {
       return this.clientService.createDialog;
   }
  set createClientDialog(value: boolean) {
       this.clientService.createDialog= value;
   }

    get paiementAchatsElement(): PaiementAchatDto {
        if( this._paiementAchatsElement == null )
            this._paiementAchatsElement = new PaiementAchatDto();
         return this._paiementAchatsElement;
    }

    set paiementAchatsElement(value: PaiementAchatDto) {
        this._paiementAchatsElement = value;
    }
    get achatItemsElement(): AchatItemDto {
        if( this._achatItemsElement == null )
            this._achatItemsElement = new AchatItemDto();
         return this._achatItemsElement;
    }

    set achatItemsElement(value: AchatItemDto) {
        this._achatItemsElement = value;
    }

    get validAchatReference(): boolean {
        return this._validAchatReference;
    }
    set validAchatReference(value: boolean) {
        this._validAchatReference = value;
    }

    get validClientCin(): boolean {
        return this._validClientCin;
    }
    set validClientCin(value: boolean) {
        this._validClientCin = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }
    get validPaiementAchatsReference(): boolean {
        return this._validPaiementAchatsReference;
    }
    set validPaiementAchatsReference(value: boolean) {
        this._validPaiementAchatsReference = value;
    }
    get validAchatItemsProduit(): boolean {
        return this._validAchatItemsProduit;
    }
    set validAchatItemsProduit(value: boolean) {
        this._validAchatItemsProduit = value;
    }
    get validAchatItemsPrixUnitaire(): boolean {
        return this._validAchatItemsPrixUnitaire;
    }
    set validAchatItemsPrixUnitaire(value: boolean) {
        this._validAchatItemsPrixUnitaire = value;
    }
    get validAchatItemsPrixVente(): boolean {
        return this._validAchatItemsPrixVente;
    }
    set validAchatItemsPrixVente(value: boolean) {
        this._validAchatItemsPrixVente = value;
    }
    get validAchatItemsQuantite(): boolean {
        return this._validAchatItemsQuantite;
    }
    set validAchatItemsQuantite(value: boolean) {
        this._validAchatItemsQuantite = value;
    }
}
