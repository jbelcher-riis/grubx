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
import { LocationMenuComponent } from './location-menu/location-menu.component';
import { ExpandableListModule } from 'angular2-expandable-list';
import { MenuItemComponent } from './menu-item/menu-item.component';
import { CategoryTableComponent } from './components/category-table/category-table.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CompanyComponent,
    LocationComponent,
    LocationListComponent,
    LocationMenuComponent,
    MenuItemComponent,
    CategoryTableComponent
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
    ReactiveFormsModule,
    ExpandableListModule
  ],
  providers: [
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
