import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthComponent } from './auth.component';
import { AuthRoutingModule } from './auth-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { MatTabsModule, MatAutocompleteModule, MatToolbarModule, MatButtonModule, MatInputModule, MatCardModule, MatCheckboxModule, MatFormFieldModule, MatIconModule, MatListModule, MatMenuModule, MatSelectModule, MatTableModule } from '@angular/material'
import { HttpModule } from '@angular/http';
import { TokenService } from './services/token.service';

@NgModule({
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatTabsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    HttpModule
  ],
  providers: [
    TokenService
  ],
  declarations: [AuthComponent]
})
export class AuthModule { }
