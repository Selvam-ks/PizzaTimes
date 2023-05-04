import { Injectable } from '@angular/core';

let TOKEN_KEY = 'auth-token';
let USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenProcessService {

  constructor() { }

  public saveToken(token:any):void{
    localStorage.removeItem(TOKEN_KEY)
    localStorage.setItem(TOKEN_KEY,token.Token)
  }

  public saveUser(user:any):void{
    localStorage.removeItem(USER_KEY)
    localStorage.setItem(USER_KEY,user.role)
  }

  public getToken(): string | null {
    return localStorage.getItem(TOKEN_KEY)
  }
  
  public getUser():any{
    const user = localStorage.getItem(USER_KEY);
    console.log(user)
    return user
    // if (user) {
    //   return JSON.parse(user);
    // }
    // return {};
  }

}
