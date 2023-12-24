import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {CategorieProduitDto} from 'src/app/controller/model/stock/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/controller/criteria/stock/CategorieProduitCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategorieProduitAdminService extends AbstractService<CategorieProduitDto, CategorieProduitCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/categorieProduit/');
    }

    public constrcutDto(): CategorieProduitDto {
        return new CategorieProduitDto();
    }

    public constrcutCriteria(): CategorieProduitCriteria {
        return new CategorieProduitCriteria();
    }
}
