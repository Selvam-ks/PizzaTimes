import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartViewComponent } from './cart-view/cart-view.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RegistrationComponent } from './registration/registration.component';
import { AuthActivGuard } from './_services/guard/auth-activ.guard';

const routes: Routes = [
  {path:"registration",component:RegistrationComponent},
  {path:"login",component:LoginComponent},
  {path:"",redirectTo:"dashboard",pathMatch:"full"},
  {path:"dashboard",component:DashboardComponent},
  {path:"edit-product",component:EditProductComponent},
  {path:"dashboard/edit-product/:name",pathMatch:'full',component:EditProductComponent},
  {path:"edit-product",component:EditProductComponent},
  {path:"dashboard/view-cart",pathMatch:'full',component:CartViewComponent,canActivate:[AuthActivGuard]},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
