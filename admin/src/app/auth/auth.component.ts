import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { TokenService } from './services/token.service';
import { UserService } from './services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
  providers: [AuthService, TokenService, UserService]
})
export class AuthComponent implements OnInit {

  login: FormGroup;                    // {1}
  signUp: FormGroup;
  private formSubmitAttempt: boolean; // {2}

  constructor(
    private fb: FormBuilder,         // {3}
    private authService: AuthService,
    private router: Router,
    private tokenService: TokenService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.login = this.fb.group({     // {5}
      email: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.signUp = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  isFieldInvalid(field: string) { // {6}
    return (
      (!this.login.get(field).valid && this.login.get(field).touched) ||
      (this.login.get(field).untouched && this.formSubmitAttempt)
    );
  }

  onLogin(model) {
    if (this.login.valid) {
      this.authService.login(model).subscribe(response => {
        this.tokenService.storeToken(response.token);
        this.authService.storeUser(response.user);
        localStorage.setItem("company", JSON.stringify(response.company));
        this.router.navigate(["/dashboard"]);
      });
    }
    this.formSubmitAttempt = true;             
  }

  onSignUp(model) {
    
    if (this.signUp.valid) {
      this.userService.signUp(model).subscribe(response => {
        this.tokenService.storeToken(response.token);
        this.authService.storeUser(response.user);
        this.router.navigate(["/dashboard"]);
      });
    }
  }
}
