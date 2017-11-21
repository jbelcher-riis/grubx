import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule, MatTabsModule, MatAutocompleteModule, MatToolbarModule, MatButtonModule, MatInputModule, MatCardModule, MatCheckboxModule, MatFormFieldModule, MatIconModule, MatListModule, MatMenuModule, MatSelectModule, MatTableModule } from '@angular/material'
import { AppComponent } from './app.component';
import { AuthModule } from './auth/auth.module';
import { AppRoutingModule } from './app-routing.module';
import { AuthGuard } from './guards/auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CompanyComponent } from './company/company.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LocationComponent } from './location/location.component';
import { LocationListComponent } from './location-list/location-list.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CompanyComponent,
    LocationComponent,
    LocationListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    MatCardModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatIconModule,
    MatListModule,
    MatMenuModule,
    MatSelectModule,
    MatTableModule,
    MatAutocompleteModule,
    MatTabsModule,
    AuthModule,
    AppRoutingModule,
    MatSidenavModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
