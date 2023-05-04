import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { RegistrationComponent } from './registration/registration.component';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductViewComponent } from './product-view/product-view.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { InterSeptInterceptor } from './_services/inter-sept.interceptor';
import { EditProductComponent } from './edit-product/edit-product.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {MatSelectModule} from '@angular/material/select';
import { OrderComponent } from './order/order.component';
import {MatBadgeModule} from '@angular/material/badge';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RegistrationComponent,
    LoginComponent,
    DashboardComponent,
    ProductViewComponent,
    CartViewComponent,
    EditProductComponent,
    PageNotFoundComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule ,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    MatSnackBarModule,
    MatCardModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatBadgeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

// providers: [{provide:HTTP_INTERCEPTORS,useClass: InterSeptInterceptor,multi:true}],
