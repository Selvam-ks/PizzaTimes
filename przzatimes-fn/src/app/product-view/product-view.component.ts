import { Component, Input } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Product } from '../models/Product';
import { RouterService } from '../_services/router.service';
import { TokenProcessService } from '../_services/token-process.service';
import { UserInService } from '../_services/user-in.service';

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.css']
})
export class ProductViewComponent {
  value_role?:boolean

  constructor(private user:UserInService,private router:RouterService,private token:TokenProcessService,private _snackBar: MatSnackBar){}

  ngOnInit(){
    let user = this.token.getUser()
    if(user === 'admin'){
      this.value_role= true
    }
  }
  @Input()
  productData?:Product[];


  add_count(product:Product){
    if(this.token.getUser() ==='user'){
      console.log(product)
      product.qty=1;
    this.user.addToUserList(product).subscribe({
      next:(value)=>{console.log(value)
        this._snackBar.open('Cart Added', '', {
        duration: 2000,
        horizontalPosition: "end",
        verticalPosition: "top",
        panelClass: ['mat-toolbar', 'mat-primary']
        });   
      },
      error:(err) => {console.error(err)
        this._snackBar.open('Already in Cart', '', {
        duration: 2000,
        horizontalPosition: "end",
        verticalPosition: "top",
        panelClass: ['mat-toolbar', 'mat-primary']
        });   
      },
    })
    }else{
      this.router.toLogin()
    }
  }
}
