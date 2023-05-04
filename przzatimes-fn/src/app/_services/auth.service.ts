import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { states } from '../models/states';
import { TokenProcessService } from './token-process.service';


const Api_url_signUp = "http://localhost:9500/pizzaTimes/product/signUp"
const Api_url_login = "http://localhost:9500/pizzaTimes/user/login"
// const Api_url_signUp = "http://localhost:10801/pizzaTimes/product/signUp"
// const Api_url_login = "http://localhost:17899/pizzaTimes/user/login"

const states_json_url = "http://localhost:3000/states"
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  IslogeddIn?:boolean;

  constructor(private http: HttpClient,private token:TokenProcessService) { }

  getStates() :Observable<any>{
    return this.http.get<Array<states>>(states_json_url)
  }
  
  register(data:any): Observable<any>{
    return this.http.post(Api_url_signUp,data)
  }

  login(data:any): Observable<any>{
    return this.http.post(Api_url_login,data)
  }
  logOut(){
    console.log('logout')
    localStorage.clear();
    this.IslogeddIn = false;
  }
  
  cheackLoginToken(data:any){
    this.IslogeddIn=(data === this.token.getToken())
    return this.IslogeddIn;
  }
}
