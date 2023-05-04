import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private  router : Router) { }

  toLogin(){
    this.router.navigateByUrl('/login')
  }
  toDashBoard(){
    this.router.navigate(['dashboard'])
  }
  reFreshDashboard(){
    this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
    this.router.navigate(['dashboard']);
  });
}
}
