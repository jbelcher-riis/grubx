import { NgModule }             from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './guards/auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component'
import { CompanyComponent } from './company/company.component';
import { LocationComponent } from './location/location.component';
import { LocationListComponent } from './location-list/location-list.component';

export const routes: Routes = [
  { path: '', loadChildren: 'app/auth/auth.module#AuthModule' },
  { path: 'dashboard', canActivate: [AuthGuard], component: DashboardComponent,
  children: [
      { path: 'company', component: CompanyComponent},
      { path: 'location-list', component: LocationListComponent},
      { path: 'location', component: LocationComponent}
  ]},
  { path: '**', redirectTo: "" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}