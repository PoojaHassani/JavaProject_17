import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { User } from './user';




@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http:HttpClient) { 
    
  }
  baseUrl:string = 'http://localhost:9091/';
  createUser(user: User){
    return this.http.post(this.baseUrl, user);
  }


}


