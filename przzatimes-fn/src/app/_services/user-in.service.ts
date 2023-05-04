import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

const user_url = "http://localhost:9500/pizzaTimes/product/"
// const user_url = "http://localhost:10801/pizzaTimes/product/"

const jsonFile = "http://localhost:3000/productList"

@Injectable({
  providedIn: 'root'
})
export class UserInService {

  constructor(private http: HttpClient) { }

  getAllProductFromUser(): Observable<any>{
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.get(user_url+'user/getAllProduct',requestClient)
  }
  getAllProduct(): Observable<any>{
    //  return this.http.get(jsonFile)
    return this.http.get(user_url+'getAllProduct')
  }

  updateToCart(product:Product){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.put(user_url+'user/updateProduct',product,requestClient)
  }
  
  deleteProduct(product_id:string){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.delete(user_url+'user/deleteProduct/'+product_id,requestClient)
  }

  addToUserList(product:Product){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.post(user_url+'user/addProduct',product,requestClient)
  }

  conformCart(product:Product[]){
    let httpHeaders = new HttpHeaders({'Authorization' : 'Bearer ' +localStorage.getItem('auth-token')})
    let requestClient = {headers:httpHeaders}
    return this.http.put(user_url+"user/conformOrder",product,requestClient)
  }



  // getAllProductFromUser(): Observable<any>{
  //   return this.http.get(user_url+'user/getAllProduct')
  // }
  // getAllProduct(): Observable<any>{
  //    return this.http.get(user_url+'getAllProduct')
  // }

  // updateToCart(product:Product){
  //   return this.http.put(user_url+'user/updateProduct',product)
  // }
  
  // deleteProduct(product_id:string){
  //   return this.http.delete(user_url+'user/deleteProduct/'+product_id)
  // }

  // addToUserList(product:Product){
  //   return this.http.post(user_url+'user/addProduct',product)
  // }

  
}
