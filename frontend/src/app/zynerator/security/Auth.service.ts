import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import {environment} from 'src/environments/environment';

import {BehaviorSubject, Observable} from 'rxjs';
import { Role } from './Role.model';
import { User } from './User.model';
import { TokenService } from './Token.service';
import {Message, MessageService} from 'primeng/api';
import {ServiceLocator} from '../service/ServiceLocator';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    readonly API = environment.loginUrl;
    public _user = new User();
    private _authenticatedUser = new User();
    private _authenticated = <boolean>JSON.parse(localStorage.getItem('autenticated')) || false;
    public _loggedIn = new BehaviorSubject<boolean>(false);
    public loggedIn$ = this._loggedIn.asObservable();
    public error: string = null;


    constructor(private http: HttpClient, private tokenService: TokenService, private router: Router, private  messageService: MessageService ) { }

    public loginAdmin(username: string, password: string) {
        this.http.post<any>(this.API + 'login', { username, password }, { observe: 'response' }).subscribe(
            resp => {
                this.error = null;
                const jwt = resp.headers.get('Authorization');
                jwt != null ? this.tokenService.saveToken(jwt) : false;
                this.loadInfos();
                this.messageService.add({
                    severity: 'success',
                    summary: 'logged successfully',
                    detail: '',
                    life: 3000
                });
                console.log('you are logged in successfully');
                this.router.navigate(['/' + environment.rootAppUrl + '/admin']);
            }, (error: HttpErrorResponse) => {
                switch (error.status) {
                    case 401:
                        this.error = 'Invalid username or password';
                        this.messageService.add({
                            severity: 'danger',
                            summary: 'logged failed',
                            detail: 'Invalid username or password',
                            life: 3000
                        });
                        break;
                    case 403:
                        this.error = 'Access forbidden';
                        this.messageService.add({
                            severity: 'danger',
                            summary: 'logged failed',
                            detail: 'Access forbidden',
                            life: 3000
                        });
                        break;
                    default:
                        this.error = 'An error occurred';
                        this.messageService.add({
                            severity: 'danger',
                            summary: 'logged failed',
                            detail: 'An error occurred',
                            life: 3000
                        });
                        break;
                }
                console.log(this.error);
            }
        );
    }


    public loadInfos() {
        const tokenDecoded = this.tokenService.decode();
        const username = tokenDecoded.sub;
        const roles = tokenDecoded.roles;
        const email = tokenDecoded.email;
        const prenom = tokenDecoded.prenom;
        const nom = tokenDecoded.nom;
        const passwordChanged = tokenDecoded.passwordChanged;
        this._authenticatedUser.passwordChanged = passwordChanged;
        this._authenticatedUser.username = username;
        this._authenticatedUser.nom = nom;
        this._authenticatedUser.prenom = prenom;
        this._authenticatedUser.email = email;
        this._authenticatedUser.roles = roles;
        localStorage.setItem('autenticated', JSON.stringify(true));
        this.authenticated = true;
        this._loggedIn.next(true);

    }


    public hasRole(role: Role): boolean {
        const index = this._authenticatedUser.roles.findIndex(r => r.authority === role.authority);
        return  index > -1 ? true : false;
    }

    public registerAdmin() {
        this.http.post<any>(this.API + 'api/users/save', this.user, {observe: 'response'}).subscribe(
            resp => {
                    this.router.navigate(['admin/admin']);
                }, (error: HttpErrorResponse) => {
                    console.log(error.error);
                }
            );
    }

    public logout() {
        this.tokenService.removeToken();
        localStorage.setItem('autenticated', JSON.stringify(false));
        this.authenticated = false;
        this._loggedIn.next(false);
        this._authenticatedUser = new User();
        this.router.navigate(['']);
    }
     get user(): User {
        return this._user;
    }

    set user(value: User) {
        this._user = value;
    }
    get authenticated(): boolean {
        return this._authenticated;
    }

    set authenticated(value: boolean) {
        this._authenticated = value;
    }
        get authenticatedUser(): User {
        return this._authenticatedUser;
    }

    set authenticatedUser(value: User) {
        this._authenticatedUser = value;
    }


}
