import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/services/auth.service';
import { Router } from '@angular/router';
import { CompanyService } from '../company/services/company.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  providers: [AuthService, CompanyService]
})
export class DashboardComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router, private companyService: CompanyService) { }

  ngOnInit() {
    if(this.companyService.getCompany() === null) {
      this.router.navigate(["/dashboard/company"]);
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/auth"]);
  }

}
