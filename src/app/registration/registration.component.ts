import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  InstituteForm:FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, 
    private userService: UserService) { }
  

    ngOnInit() {
      this.InstituteForm = this.formBuilder.group({
        state:[''],
        instituteName: [''],
        instituteCode:[''],
        diseCode: [''],
        universityState: [''],
        universityName: [''],
        setPassword: [''],
        confirmPassword: ['']
      
      });

}
onInstituteSubmit(){
  this.submitted = true;
    if(this.InstituteForm.invalid){
      return;
    }
    this.userService.createUser(this.InstituteForm.value)
      .subscribe( data => {
        //this.router.navigateByUrl();
        alert("institute is added");
      });
}
}

