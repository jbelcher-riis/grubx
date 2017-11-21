import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

@Injectable()
export class UserService {

  constructor(private http: Http) { }

  private url = '/api/v1/users';

  signUp(model) {
    return this.http.post(this.url, model)
      .map((res: Response) => res.json());
  }

}
