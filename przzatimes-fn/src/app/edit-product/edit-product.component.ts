import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../models/Product';
import { AdminCrdService } from '../_services/admin-crd/admin-crd.service';
import { RouterService } from '../_services/router.service';
import { TokenProcessService } from '../_services/token-process.service';

const inputField = document.getElementById('name') as HTMLInputElement | null;

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})

export class EditProductComponent {
  constructor(private adminCrd:AdminCrdService ,private actRout:ActivatedRoute,private routing:RouterService,private token :TokenProcessService){}
  
  newProduct?:boolean;
  onChangeFile(event: any){
    let rederFile = new FileReader();
    console.log(event.target.files)
    if(event.target.files){
      rederFile.readAsDataURL(event.target.files[0])
      rederFile.onload = (e:any)=>{
        this.productEdit.imageurl = e.target.result;
      }
    }
  }
  stopBack:boolean= false;
  productEdit:Product|any = {
    product_id: 0,
    name: '',
    type_vg: '',
    description: '',
    crust:'',
    size: '',
    price: 0,
    imageurl: ''
  }
  ngOnInit():void{
    this.actRout.paramMap.subscribe(data=>{
      let n_id = data.get('name') ?? null
      console.log(n_id)
      if(n_id!=null){
        this.newProduct=true;
        inputField?.setAttribute('disabled', '');
        this.adminCrd.getOneProduct(n_id).subscribe(product=>{
          this.productEdit = product;
          this.stopBack = false;
        })
      }
    })
  }

 onSubmit(){
  console.log(this.productEdit)
  if(this.productEdit){
    this.adminCrd.addProductTOData(this.productEdit).subscribe({
      next: (data)=>{
        console.log(data)
        this.routing.toDashBoard()
      },
      error(err) {
        console.log(err.message)
      },
    })
  }}

  onUpdate(){
    console.log(this.productEdit)
    this.adminCrd.updateProduct(this.productEdit).subscribe({
      next: (data)=>{console.log(data)
        this.stopBack = true;
        this.routing.toDashBoard()},
      error(err) {console.log(err)},
    })
  }
  onDelete(){
    this.adminCrd.deleteProduct(this.productEdit.name).subscribe({
      next: (data)=>{console.log(data)
        this.stopBack = true;
        this.routing.toDashBoard()},
      error(err) {console.log(err)},
    })
  }
  
  canDeactivate(){
    if(!this.stopBack){
       this.stopBack = confirm("do woant to back without saving")
       console.log(this.stopBack)
    }
      return this.stopBack;
  }
}
