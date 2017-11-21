import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { TokenService } from './token.service';

@Injectable()
export class AuthService {

  constructor(private http: Http, private tokenService: TokenService) { }
  
    private url = '/api/v1/auth';
  
    login(model) {
     
      return this.http.post(this.url, model)
        .map((res: Response) => res.json());
    }

    storeUser(user){
      localStorage.setItem("user",JSON.stringify(user));
    }

    getUser(){
      return JSON.parse(localStorage.getItem("user"));
    }

    isLoggedIn(){
      return this.tokenService.getToken() ? true : false;
    }

    logout() {
      localStorage.clear()
    }

}
