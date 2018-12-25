import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  tempdata: Profile = new Profile();
  profileBean: Profile = new Profile();
  registerForm: FormGroup
  submitted = false;
  gender = '';
  genderFlag = true;
  //  constructor(private formBuilder: FormBuilder) { }
  constructor(private router: Router, private formBuilder: FormBuilder,
    private userService: UserserviceService) {
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
    this.registerForm = this.formBuilder.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        dob: ['', Validators.required],
        email: ['', [Validators.required, Validators.email, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$')]],
        gender: [''],
        pincode: ['', [
          Validators.required, Validators.minLength(6), Validators.maxLength(6) ]
        ],
        mobile: ['', [
          Validators.required, Validators.pattern('[6-9][0-9]{9}')]
        ],
        password: ['',
        [Validators.required, Validators.minLength(6),
        Validators.pattern('^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$')]],
        question: ['', Validators.required],
        answer: ['',
        [Validators.required, Validators.minLength(1)]]

    });
}
get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    this.registerForm.value.gender = this.gender;
    if (this.registerForm.invalid) {
        return;
    }
}

isValidForm() {
  if (this.registerForm.invalid || !this.isGender() ) {
      return false;
  } else {
    return true;
  }
}
updateGender(gender) {
  if (gender === 1) {
    this.gender = 'male';
  }
  if (gender === 2) {
    this.gender = 'female';
  }
  if (gender === 3) {
    this.gender = 'other';
  }
}

isGender() {

  if (this.gender.length > 0) {
    return true;
  }
  return false;
}

register() {
  this.profileBean.firstName = this.registerForm.value.firstName;
  this.profileBean.lastName = this.registerForm.value.lastName;
  if(this.registerForm.value.gender){
    this.profileBean.gender = this.registerForm.value.gender;
  }
  else{
    this.profileBean.gender = 'male';
  }
  this.profileBean.dateOfBirth = this.registerForm.value.dob;
  this.profileBean.emailID = this.registerForm.value.email;
  this.profileBean.pincode = this.registerForm.value.pincode;
  this.profileBean.mobileNo = this.registerForm.value.mobile;
  this.profileBean.password = this.registerForm.value.password;
  this.profileBean.authQuestion = this.registerForm.value.question;
  this.profileBean.authAnswer = this.registerForm.value.answer;

  console.log(this.profileBean);
  this.userService.registration(this.profileBean)
  .subscribe(data => {
    this.tempdata = data;
  });
}

}


