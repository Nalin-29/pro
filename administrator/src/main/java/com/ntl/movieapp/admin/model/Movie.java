package com.ntl.movieapp.admin.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Movie {
	
/*
 * 
 *  
 *   
 *   Video Movie 
 *   Age Limit 
 *   Movie Category
 *   Movie Language
 * 	
 */
	
 public Movie() {
		super();
	}

@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int movieId;
 private String movieName;
 private String moviePosterUrl;   
 private LocalDate movieReleaseDate;
 private String movieDescription;
 private String movieVideoUrl;
 private String movieCategory;
 private String movieLanguage;
 private int movieAgeLimit;
 
    

 
 public Movie(int movieId, @NotNull String movieName, @NotNull String moviePosterUrl,
		@NotNull LocalDate movieReleaseDate, @NotNull String movieDescription) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.moviePosterUrl = moviePosterUrl;
	this.movieReleaseDate = movieReleaseDate;
	this.movieDescription = movieDescription;
}



public int getMovieId() {
  return movieId;
 }
 
 public void setMovieId(int movieId) {
  this.movieId = movieId;
 }
 
 public String getMovieName() {
  return movieName;
 }
 
 public void setMovieName(String movieName) {
  this.movieName = movieName;
 }
 
 public String getMoviePosterUrl() {
  return moviePosterUrl;
 }
 
 public void setMoviePosterUrl(String moviePosterUrl) {
  this.moviePosterUrl = moviePosterUrl;
 }

 
 public LocalDate getMovieReleaseDate() {
	return movieReleaseDate;
}

public void setMovieReleaseDate(LocalDate movieReleaseDate) {
	this.movieReleaseDate = movieReleaseDate;
}



public String getMovieDescription() {
	return movieDescription;
}

public void setMovieDescription(String movieDescription) {
	this.movieDescription = movieDescription;
}



public String getMovieVideoUrl() {
	return movieVideoUrl;
}



public void setMovieVideoUrl(String movieVideoUrl) {
	this.movieVideoUrl = movieVideoUrl;
}



public String getMovieCategory() {
	return movieCategory;
}



public void setMovieCategory(String movieCategory) {
	this.movieCategory = movieCategory;
}



public String getMovieLanguage() {
	return movieLanguage;
}



public void setMovieLanguage(String movieLanguage) {
	this.movieLanguage = movieLanguage;
}



public int getMovieAgeLimit() {
	return movieAgeLimit;
}



public void setMovieAgeLimit(int movieAgeLimit) {
	this.movieAgeLimit = movieAgeLimit;
}


 
}

