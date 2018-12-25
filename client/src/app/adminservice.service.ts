import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Movie } from './movie';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  private baseUrl1 = 'http://localhost:8765';

  constructor(private http: HttpClient) { }

  public saveMovie1(movie){
    return this.http.post<Movie>(this.baseUrl1 + '/administrator/addMovie',movie);
  }
  public editMovie(movie){
    return this.http.post<Movie>(this.baseUrl1 + '/administrator/editMovie',movie);
  }
  public getAllMovie(){
    return this.http.get<Movie[]>(this.baseUrl1 + '/administrator/getAllMovie');
  }
  public deleteMovie(movieId){
    return this.http.post<number>(this.baseUrl1 + '/administrator/deleteMovie/' + movieId, movieId);
  }
}
