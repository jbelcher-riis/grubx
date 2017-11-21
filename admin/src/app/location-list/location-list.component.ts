import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {CompanyService} from '../company/services/company.service';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css'],
  providers: [CompanyService]
})
export class LocationListComponent implements OnInit {
  private locationForm: FormGroup;
  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getCompanyLocations().subscribe(response =>{
      this.locations = response;
    });
  }

  locations = [];



}
