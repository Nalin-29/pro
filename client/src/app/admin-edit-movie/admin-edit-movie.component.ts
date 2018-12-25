import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../movie';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-admin-edit-movie',
  templateUrl: './admin-edit-movie.component.html',
  styleUrls: ['./admin-edit-movie.component.css']
})
export class AdminEditMovieComponent implements OnInit {
  movie = new Movie();
  addMovieForm :FormGroup;
  
  @Input() editOneMovie:Movie;
  
   constructor(private router: Router, private  formBuilder: FormBuilder, 
    private service: AdminserviceService) {
    }
    ngOnInit() {
 
      this.addMovieForm =this.formBuilder.group({
      movieName :['',[Validators.required, Validators.minLength(3)]],
      posterUrl:['',[Validators.required, Validators.pattern('https://.*')]],
      releaseDate : ['',[Validators.required]],
      description: ['',[Validators.required, Validators.minLength(20), Validators.maxLength(150)]],
      videoUrl: ['',[Validators.required, Validators.pattern('https://.*')]],
      category : ['',[Validators.required]],
      ageLimit :['',[Validators.required]],
      language :['',[Validators.required]]
  
      });
    }
 
   onSubmit(){
 
   }
   isValid(){
    if(this.addMovieForm.invalid)
    {
      return false;
    }
    else{
      return true;
    }
  }
   editData(){

  
    this.movie.movieId = this.editOneMovie.movieId;
    if(this.addMovieForm.value.movieName){
      this.editOneMovie.movieName = this.addMovieForm.value.movieName;
    }
    if(this.addMovieForm.value.posterUrl){
      this.editOneMovie.moviePosterUrl = this.addMovieForm.value.posterUrl;
    }
   if(this.addMovieForm.value.posterUrl){
     
   
    this.editOneMovie.moviePosterUrl = this.addMovieForm.value.posterUrl;
   }
   if(this.addMovieForm.value.releaseDate){
    this.editOneMovie.movieReleaseDate = this.addMovieForm.value.releaseDate;
  }
  if(this.addMovieForm.value.description){
    this.editOneMovie.movieDescription = this.addMovieForm.value.description;
  }
  if(this.addMovieForm.value.videoUrl){
    this.editOneMovie.movieVideoUrl = this.addMovieForm.value.videoUrl;
  }
  if(this.addMovieForm.value.category){

    this.editOneMovie.movieCategory = this.addMovieForm.value.category;
  }
  if(this.addMovieForm.value.language){
    this.editOneMovie.movieLanguage = this.addMovieForm.value.language;
  }
  if(this.addMovieForm.value.ageLimit){
    this.editOneMovie.movieAgeLimit = this.addMovieForm.value.ageLimit;
  }
     console.log(this.editOneMovie);
     this.service.editMovie(this.editOneMovie)
     .subscribe(data => {
         alert("Edit Success");
     });
   }
 }