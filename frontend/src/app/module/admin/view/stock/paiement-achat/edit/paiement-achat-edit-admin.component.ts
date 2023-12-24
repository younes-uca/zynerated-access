import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaiementAchatAdminService} from 'src/app/controller/service/admin/stock/PaiementAchatAdmin.service';
import {PaiementAchatDto} from 'src/app/controller/model/stock/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/stock/PaiementAchatCriteria.model';


import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';

@Component({
  selector: 'app-paiement-achat-edit-admin',
  templateUrl: './paiement-achat-edit-admin.component.html'
})
export class PaiementAchatEditAdminComponent extends AbstractEditController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatAdminService>   implements OnInit {


    private _validPaiementAchatReference = true;

    private _validAchatReference = true;



    constructor( private paiementAchatService: PaiementAchatAdminService , private achatService: AchatAdminService) {
        super(paiementAchatService);
    }

    ngOnInit(): void {
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
    }
    public prepareEdit() {
        this.item.datePaiement = this.paiementAchatService.format(this.item.datePaiement);
    }



    public setValidation(value: boolean){
        this.validPaiementAchatReference = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementAchatReference();
    }
    public validatePaiementAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validPaiementAchatReference = false;
        } else {
            this.validPaiementAchatReference = true;
        }
    }



   public async openCreateAchat(achat: string) {
        const isPermistted = await this.roleService.isPermitted('Achat', 'edit');
        if (isPermistted) {
             this.achat = new AchatDto();
             this.createAchatDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get achat(): AchatDto {
       return this.achatService.item;
   }
  set achat(value: AchatDto) {
        this.achatService.item = value;
   }
   get achats(): Array<AchatDto> {
        return this.achatService.items;
   }
   set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
   }
   get createAchatDialog(): boolean {
       return this.achatService.createDialog;
   }
  set createAchatDialog(value: boolean) {
       this.achatService.createDialog= value;
   }


    get validPaiementAchatReference(): boolean {
        return this._validPaiementAchatReference;
    }
    set validPaiementAchatReference(value: boolean) {
        this._validPaiementAchatReference = value;
    }

    get validAchatReference(): boolean {
        return this._validAchatReference;
    }
    set validAchatReference(value: boolean) {
        this._validAchatReference = value;
    }
}
