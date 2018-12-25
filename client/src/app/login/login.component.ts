import { Component, OnInit } from '@angular/core';
import { Credentials } from '../credentials';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserserviceService } from '../userservice.service';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  credBean: Credentials= new Credentials();
  credentialsBean: Credentials = new Credentials();
  loginMessage: string;
  constructor(private router: Router, private userService: UserserviceService) {
    if (localStorage.getItem('userId')) {
      if(localStorage.getItem('userType')==='admin'){
        this.router.navigate(['/adminhome']);
      }
      else if(localStorage.getItem('userType')=='user'){
        this.router.navigate(['/home']);
      }
     }
  }

  ngOnInit() {

  }

  login(): void {
    this.userService.UserLogin(this.credentialsBean)
    .subscribe(data => { this.credBean = data;
        if (this.credBean.userID === this.credentialsBean.userID) {
          const str = this.credentialsBean.userID + '';
          localStorage.setItem('userId', str);
          if(this.credentialsBean.userID==='Vi9690'){
            localStorage.setItem('userType','admin');
             this.router.navigate(['/adminhome']);
          }
          else{
            localStorage.setItem('userType','user');
            this.router.navigate(['/home']);
          }
        } else {
       }
      }, (error)=>{
        console.log("Error From server side, try again" + error);
        console.log(error.error);
      });
      this.loginMessage = 'Use correct userid and password';
    }

}
