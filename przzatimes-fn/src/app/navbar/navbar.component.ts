import { Component } from '@angular/core';
import { UserInService } from '../_services/user-in.service';
import { Injectable } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenProcessService } from '../_services/token-process.service';
import { RouterService } from '../_services/router.service';

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent {

  value?:boolean
  value_crt?:boolean;
  value_edit?:boolean
  constructor(private token:TokenProcessService,private auth:AuthService,private router:RouterService){}

  changeValue(){
    let role = this.token.getUser()
    this.value=true;
    if(role === 'admin'){
      this.value_edit=true
    }else{
      this.value_crt= true
    }
  }
  logOutAll(){
    this.auth.logOut()
    this.value= false
    this.value_crt= false
    this.value_edit= false
    this.router.toLogin()
  }
}
