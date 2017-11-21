import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import { CompanyService} from '../company/services/company.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css'],
  providers: [CompanyService]
})
export class LocationComponent implements OnInit {

  constructor(private fb: FormBuilder, private router: Router, private companyService: CompanyService) { }

  private locationForm: FormGroup;

  ngOnInit() {
    this.locationForm = this.fb.group({
      longitude: [''],
      latitude: [''],
      phone: ['', Validators.required],
      email: ['', Validators.required],
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

  onSubmit(model) {
    this.companyService.storeCompanyLocation(model).subscribe(response=>{
      var company = {
        id: response.id,
        latitude: response.latitude,
        logitude: response.longitude,
        phone: response.phone,
        address: response.address,
        name: response.name,
        email: response.email
      }
      
      this.router.navigate(["/dashboard/location-list"]);
    });
  }
}
