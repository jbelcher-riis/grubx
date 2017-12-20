import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { CompanyService } from '../company/services/company.service';
import { Category } from '../models/category';
import { TokenService } from '../auth/services/token.service';

@Injectable()
export class CategoryService {

  constructor(private http: Http, private companyService: CompanyService, private tokenService: TokenService) { }

  private baseUrl:string = "/api/v1/companies/";

  getCategories():Observable<Category[]> {
    let company = this.companyService.getCompany();
    var headers = new Headers({ 'Authorization': 'Bearer ' + this.tokenService.getToken() });
    let url = this.baseUrl + company.id + "/categories"
    return this.http.get(url, {headers: headers})
      .map((res: Response) => res.json());
   }
}
