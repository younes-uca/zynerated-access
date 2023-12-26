import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';

import { AuthService } from 'src/app/zynerator/security/Auth.service';
import {Message} from 'primeng/api';


@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.scss']
})
export class LoginAdminComponent implements OnInit {
  loginForm = new FormGroup({
    username: new FormControl('',Validators.required),
    password: new FormControl('',Validators.required)
  });
  constructor(private _authService: AuthService, private router: Router) { }
  messages: Message[] | undefined;
  ngOnInit(): void {
  }

  submit(){
    const formValues = this.loginForm.value;
    const username = formValues.username;
    const passowrd = formValues.password;
    this._authService.loginAdmin(username, passowrd);
  }
    register(){
    this.router.navigate(['/admin/register']);
  }

  get authService(): AuthService {
    return this._authService;
  }

  set authService(value: AuthService) {
    this._authService = value;
  }
}
