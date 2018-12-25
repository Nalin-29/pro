package com.ntl.movieapp.search.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Movie 
{
	
		
   public Movie()
   {
		super();
	}


 
	 private int movieId;
	 private String movieName;
	 private String moviePosterUrl;
	 private LocalDate movieReleaseDate;
	 private String movieDescription;
	 private int movieAgeLimit;
	 private String moviecategory;
	 private String movieVideoUrl;
	 private String movieLanguage;
	 
	 
	 public int getMovieAgeLimit() 
	 {
		return movieAgeLimit;
	}
	
	
	
	public void setMovieAgeLimit(int movieAgeLimit) 
	{
		this.movieAgeLimit = movieAgeLimit;
	}
	
	
	
	 
	    
	
	 
	 public String getMoviecategory()
	 {
		return moviecategory;
	}
	
	
	
	public void setMoviecategory(String moviecategory)
	{
		this.moviecategory = moviecategory;
	}
	
	
	
	public String getMovieVideoUrl() 
	{
		return movieVideoUrl;
	}
	
	
	
	public void setMovieVideoUrl(String movieVideoUrl)
	{
		this.movieVideoUrl = movieVideoUrl;
	}
	
	
	
	public String getMovieLanguage()
	{
		return movieLanguage;
	}
	
	
	
	public void setMovieLanguage(String movieLanguage) 
	{
		this.movieLanguage = movieLanguage;
	}
	
	
	
	public Movie(int movieId,  String movieName,String moviePosterUrl,
			 LocalDate movieReleaseDate, String movieDescription)
	{
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.moviePosterUrl = moviePosterUrl;
		this.movieReleaseDate = movieReleaseDate;
		this.movieDescription = movieDescription;
		
	}
	
	
	
	public int getMovieId() 
	{
	  return movieId;
	 }
	 
	 public void setMovieId(int movieId)
	 {
	  this.movieId = movieId;
	 }
	 
	 public String getMovieName() 
	 {
	  return movieName;
	 }
	 
	 public void setMovieName(String movieName)
	 {
	  this.movieName = movieName;
	 }
	 
	 public String getMoviePosterUrl()
	 {
	  return moviePosterUrl;
	 }
	 
	 public void setMoviePosterUrl(String moviePosterUrl) 
	 {
	  this.moviePosterUrl = moviePosterUrl;
	 }
	
	 
	 public LocalDate getMovieReleaseDate()
	 {
		return movieReleaseDate;
	}
	
	public void setMovieReleaseDate(LocalDate movieReleaseDate)
	{
		this.movieReleaseDate = movieReleaseDate;
	}
	
	
	
	public String getMovieDescription()
	{
		return movieDescription;
	}
	
	public void setMovieDescription(String movieDescription)
	{
		this.movieDescription = movieDescription;
	}
	
	 
}
	
