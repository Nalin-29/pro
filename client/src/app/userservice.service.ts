import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Credentials } from './credentials';
import { Profile } from './profile';

import { trigger, transition, style, group, query, animate } from '@angular/animations';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http: HttpClient) { }

  private baseUrl1 = 'http://localhost:8765';


  public UserLogin(credentialsBean) {
    return this.http.post<Credentials>(this.baseUrl1 + '/login-signup-movies/login', credentialsBean);
   }
   public registration(profileBean) {
     return this.http.post<Profile>(this.baseUrl1 + '/login-signup-movies/register', profileBean);
   }
   public UserLogout(userID) {
    return this.http.get(this.baseUrl1 + '/login-signup-movies' + userID);
   }
  
   public forgotPassword(credentialsBean) {
    return this.http.post<Credentials>(this.baseUrl1 + '/login-signup-movies/forgotPassword', credentialsBean);
   }
   public getUserDetails(userId){
    return this.http.get<Profile>(this.baseUrl1 + '/login-signup-movies/getUser/' +userId);
   }

}
