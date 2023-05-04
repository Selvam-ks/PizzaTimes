import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from 'src/app/models/Product';

// const admin_url = "http://localhost:10801/pizzaTimes/product/"
const admin_url = "http://localhost:9500/pizzaTimes/product/"

@Injectable({
  providedIn: 'root'
})
export class AdminCrdService {

  constructor(private http: HttpClient) { }

  addProductTOData(product:Product){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    console.log(requestClient)
    return this.http.post(admin_url+'admin/addProduct',product,requestClient)
  }

  getOneProduct(product_name:string|null){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.get(admin_url+'admin/getProduct/'+product_name,requestClient)
  }
  updateProduct(product:Product){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.put(admin_url+'admin/update',product,requestClient)
  }

  deleteProduct(product_name:string){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.delete(admin_url+'admin/delete/'+product_name,requestClient)
  }
}
