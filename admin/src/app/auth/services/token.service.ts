import { Injectable } from '@angular/core';

@Injectable()
export class TokenService {

  constructor() { }

  storeToken(token: string) {
    localStorage.setItem("token",token);
  }

  getToken(){
    return localStorage.getItem("token");
  }
}
