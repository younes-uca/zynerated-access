import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PermissionDto} from 'src/app/controller/model/stock/Permission.model';
import {PermissionCriteria} from 'src/app/controller/criteria/stock/PermissionCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PermissionAdminService extends AbstractService<PermissionDto, PermissionCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/permission/');
    }

    public constrcutDto(): PermissionDto {
        return new PermissionDto();
    }

    public constrcutCriteria(): PermissionCriteria {
        return new PermissionCriteria();
    }
}
