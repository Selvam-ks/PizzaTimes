import { Component } from '@angular/core';
import { Product } from '../models/Product';
import { AuthService } from '../_services/auth.service';
import { UserInService } from '../_services/user-in.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  allProductList:Product[]=[];
  fromUser:Product[]=[];

  constructor(private userServ:UserInService,private auth:AuthService){}

  ngOnInit(){
    this.userServ.getAllProduct().subscribe({
      next: data =>{
        this.allProductList = data
        console.log(this.allProductList)
      }
    })
    // console.log('getAllPRoductFromUSer')
    // this.userServ.getAllProductFromUser().subscribe({
    //   next(value) {

    //     console.log(value);
    //   },
    //   error(err){
    //     console.log(err)
    //   }
    // })
  }
  isLogin(){
    this.auth.IslogeddIn = true;
    
  }
}
