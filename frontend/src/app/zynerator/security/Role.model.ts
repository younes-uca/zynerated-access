import {PermissionDto} from './Permission.model';

export class Role {
    public authority: string;
    public id: string;
    public permissions: PermissionDto[];

    constructor() {
        this.authority = "ROLE_ANONYMOUS";
    }
}
