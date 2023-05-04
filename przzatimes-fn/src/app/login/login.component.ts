import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';
import { AuthService } from '../_services/auth.service';
import { TokenProcessService } from '../_services/token-process.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private fb :FormBuilder,private userServ:AuthService,private router:Router,private tokenStore:TokenProcessService,
              private navBar:NavbarComponent,private _snackBar: MatSnackBar){}
  userLog = this.fb.group({
    email:['',Validators.required],
    password:['',Validators.required]
  });
  errorMessage='';
  falied?:boolean
  getLoginData():void{
    console.log(this.userLog.value)
    this.userServ.login(this.userLog.value).subscribe({
      next:data=>{
        localStorage.setItem('Token',data.Token)
        localStorage.setItem('Role',data.role)
        this.tokenStore.saveToken(data)
        this.tokenStore.saveUser(data)
        this._snackBar.open('welcome', '', {
        duration: 3000,
        panelClass: ['mat-toolbar', 'mat-primary']
        });
        if(this.userServ.cheackLoginToken(data.Token)){
          // console.log(this.tokenStore.getUser())
          this.router.navigateByUrl('/dashboard')
          this.navBar.changeValue()
        }
      },
      error: err=>{
        this.falied= true;
        this.errorMessage=err.error.text;
        this._snackBar.open('Please Check Your Information', '', {
        duration: 2000,
        horizontalPosition:"center",
        verticalPosition:"top",
        panelClass: ['mat-toolbar', 'mat-primary']
        });
      }
    })
  }
}
