package com.ntl.movieapp.favourite.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Favourites {
	
	
	
	 public Favourites() {
		super();
	}


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int favouriteId;
	 	
	private int movieId;
	
	private String userId;
	
	private String movieName;
	private String moviePosterUrl;
	private String movieReleaseDate;
	private String movieDescription;

	
	
	

	public Favourites(int favouriteId,int movieId,String userId, String movieName,
			String moviePosterUrl, String movieReleaseDate,String movieDescription) {
		super();
		this.favouriteId = favouriteId;
		this.movieId = movieId;
		this.userId = userId;
		this.movieName = movieName;
		this.moviePosterUrl = moviePosterUrl;
		this.movieReleaseDate = movieReleaseDate;
		this.movieDescription=movieDescription;
	}





	public Favourites(@NotNull int movieId, @NotNull String userId) {
		super();
		this.movieId = movieId;
		this.userId = userId;
	}




	public int getFavouriteId() {
		return favouriteId;
	}



	public void setFavouriteId(int favouriteId) {
		this.favouriteId = favouriteId;
	}



	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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





	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}





	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}





	public String getMovieDescription() {
		return movieDescription;
	}





	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}





	

	
}
