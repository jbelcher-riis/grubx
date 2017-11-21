import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { TokenService } from '../../auth/services/token.service';

@Injectable()
export class CompanyService {

  private url = '/api/v1/companies';

  constructor(private http: Http, private tokenService: TokenService) { }

  getCompany() {
    return JSON.parse(localStorage.getItem("company"));
  }

  storeCompany(model) {
    var headers = new Headers({ 'Authorization': 'Bearer ' + this.tokenService.getToken() });
    return this.http.post(this.url, model, {headers: headers})
      .map((res: Response) => res.json());
  }

  storeCompanyLocation(model) {
    var headers = new Headers({ 'Authorization': 'Bearer ' + this.tokenService.getToken() });
    var companyId = JSON.parse(localStorage.getItem("company")).id;
    return this.http.post(this.url+"/"+companyId+"/locations", model, {headers: headers})
      .map((res: Response) => res.json());
  }

  getCompanyLocations() {
    var headers = new Headers({ 'Authorization': 'Bearer ' + this.tokenService.getToken() });
    var companyId = JSON.parse(localStorage.getItem("company")).id;
    return this.http.get(this.url+"/"+companyId+"/locations", {headers: headers})
      .map((res: Response) => res.json());
  }
}
