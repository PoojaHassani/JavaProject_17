import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  url =String("http://localhost:9091/");
  loginForm: FormGroup;
  instituteCode:number;
  setPassword:String;
  result:any;
  constructor(private formBuilder: FormBuilder, private router: Router,private http:HttpClient) { }


  onLogin():void{
    let tempUrl = this.url + this.loginForm.controls['instituteCode'].value + "/" + 
                  this.loginForm.controls['setPassword'].value;
    this.http.get(tempUrl).subscribe(data=>{
      alert("login is successful");
      this.result=data;
     

    },
    error=> alert("error"))
  }

  ngOnInit() {
    this.loginForm=this.formBuilder.group({
      instituteCode:['', Validators.required],
      setPassword:['', Validators.required]
    });

    
  }

}
