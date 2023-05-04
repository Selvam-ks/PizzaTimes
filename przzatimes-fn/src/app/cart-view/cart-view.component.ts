import { Component } from '@angular/core';
import { Product } from '../models/Product';
import { UserInService } from '../_services/user-in.service';
import { Injectable } from '@angular/core';
import { RouterService } from '../_services/router.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})
export class CartViewComponent {

  constructor(private userCrd:UserInService,private router:RouterService,private _snackBar: MatSnackBar){}
  
  cartEmpty?:boolean
  productList:Product[]=[];

  totalPrice:number=0

  ngOnInit(){
    this.getProduct()
  }
  getProduct(){
    this.userCrd.getAllProductFromUser().subscribe({
     next:(value)=>{
      this.productList=value
      this.totalCal()
      if(this.productList != null){
        this.cartEmpty =true
      }
       console.log(value)
     }})
  }
  totalCal(){
    for(let values of this.productList){
      this.totalPrice = this.totalPrice + (values.price * values.qty)
    }
  }
  gtyAdd(product:Product){
    product.qty++
    this.totalPrice = this.totalPrice + product.price
    this.updateProduct(product)
  }
  gtySub(product:Product){
    if(product.qty==1){
      this.totalPrice = this.totalPrice - product.price
      this.deletePro(product)
    }else{
      product.qty--
      this.totalPrice = this.totalPrice - product.price
    this.updateProduct(product)
    }
  }
  updateProduct(product:Product){
    this.userCrd.updateToCart(product).subscribe({
      next:values=>{
        console.log(values)
      },
      error:err=>{console.log(err)}
    })
  }
  deletePro(product:Product){
    this.userCrd.deleteProduct(product.name).subscribe({
      next:(val)=>{
        console.log(val)
        this.router.reFreshDashboard()
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }

  conformCart(){
    this.userCrd.conformCart(this.productList).subscribe({
      next:value=>{
        console.log(value)
        this._snackBar.open('Thank you For your Order', 'ok', {
          duration: 2000,
          horizontalPosition:"center",
          verticalPosition:"top",
          panelClass: ['mat-toolbar', 'mat-primary']
          });
          this.router.toDashBoard();
      }
    })
  }
}
