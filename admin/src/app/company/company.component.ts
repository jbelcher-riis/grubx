import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CompanyService } from './services/company.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css'],
  providers: [CompanyService]
})
export class CompanyComponent implements OnInit {
  private signUpForm: FormGroup;

  constructor(
    private fb: FormBuilder, 
    private companyService: CompanyService,
    private router: Router   
  ) { }

  ngOnInit() {
    this.signUpForm = this.fb.group({     // {5}
      phone: ['', Validators.required],
      name: ['', Validators.required],
      address: this.fb.group({
        address: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        zip: ['', Validators.required],
        suite: ['', Validators.required],
      })
    });
  }

  onSubmit(model){
    this.companyService.storeCompany(model).subscribe(response=>{
      var company = {
        id: response.id,
        name: response.name,
        phone: response.phone,
        address: response.address
      }
      localStorage.setItem("company", JSON.stringify(company));
      this.router.navigate(["/dashboard"]);
    });
  }
}
