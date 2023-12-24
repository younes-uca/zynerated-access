import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PaiementAchatDto} from 'src/app/controller/model/stock/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/stock/PaiementAchatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaiementAchatAdminService extends AbstractService<PaiementAchatDto, PaiementAchatCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paiementAchat/');
    }

    public constrcutDto(): PaiementAchatDto {
        return new PaiementAchatDto();
    }

    public constrcutCriteria(): PaiementAchatCriteria {
        return new PaiementAchatCriteria();
    }
}
