import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementAchatAdminService} from 'src/app/controller/service/admin/stock/PaiementAchatAdmin.service';
import {PaiementAchatDto} from 'src/app/controller/model/stock/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/stock/PaiementAchatCriteria.model';

import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
@Component({
  selector: 'app-paiement-achat-view-admin',
  templateUrl: './paiement-achat-view-admin.component.html'
})
export class PaiementAchatViewAdminComponent extends AbstractViewController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatAdminService> implements OnInit {


    constructor(private paiementAchatService: PaiementAchatAdminService, private achatService: AchatAdminService){
        super(paiementAchatService);
    }

    ngOnInit(): void {
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


}
