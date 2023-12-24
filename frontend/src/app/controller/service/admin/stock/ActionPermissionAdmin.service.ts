import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {ActionPermissionDto} from 'src/app/controller/model/stock/ActionPermission.model';
import {ActionPermissionCriteria} from 'src/app/controller/criteria/stock/ActionPermissionCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ActionPermissionAdminService extends AbstractService<ActionPermissionDto, ActionPermissionCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/actionPermission/');
    }

    public constrcutDto(): ActionPermissionDto {
        return new ActionPermissionDto();
    }

    public constrcutCriteria(): ActionPermissionCriteria {
        return new ActionPermissionCriteria();
    }
}
