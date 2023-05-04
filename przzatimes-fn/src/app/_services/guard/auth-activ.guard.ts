import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, CanDeactivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { EditProductComponent } from 'src/app/edit-product/edit-product.component';
import { AuthService } from '../auth.service';
import { RouterService } from '../router.service';

@Injectable({
  providedIn: 'root'
})
export class AuthActivGuard implements CanActivate, CanActivateChild, CanDeactivate<unknown> {
  constructor(private authServ:AuthService , private router:RouterService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(!this.authServ.IslogeddIn){
       this.router.toLogin();
       return false
    }else{
      return true;
    }
  }
  canActivateChild(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return true;
  }
  canDeactivate(
    component: EditProductComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return component.canDeactivate ? component.canDeactivate(): true;
  }
  
}
