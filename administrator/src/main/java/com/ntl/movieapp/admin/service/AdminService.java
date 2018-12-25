package com.ntl.movieapp.admin.service;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ntl.movieapp.admin.dao.AdminDao;
import com.ntl.movieapp.admin.model.Movie;


@Service
public class AdminService {
	
	@Autowired
	AdminDao dao;
	
	

	public AdminService() {
		super();
	}

	public AdminService(AdminDao dao) {
		super();
		this.dao=dao;
	}
	
	public List<Movie> allMoviesByTitle(String movieName){
		
		return dao.findMoviesByTitle(movieName);
	}
	
	public List<Movie> allMoviesByCategory(String movieCategory) {
		return dao.findMoviesByCategory(movieCategory);
	}
	public List<Movie> allMoviesByLanguage(String movieLanguage) {
		return dao.findMoviesByLanguage(movieLanguage);
	}
	
	public List<Movie> allMoviesById(List<Integer> listOfId){
		return dao.findAllById(listOfId);	
	}

	public Movie addMovie(Movie movie) {
		System.out.println("Admin Service");
		return dao.save(movie);
	}

	public Movie editMovie(Movie movie) {
		Optional<Movie> m = dao.findById(movie.getMovieId());
		if(m.isPresent()) {
			return dao.saveAndFlush(movie);
		}
		else {
			return new Movie();
		}
	}
	
	public int deleteMovie(int movieId) {
		try {
			dao.deleteById(movieId);
			return 1;
		}
		catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}

	public Optional<Movie> viewMovie(int movieId) {
		return dao.findById(movieId);
	}

	public List<Movie> getAllMovie() {
		return dao.findAll();
	}


	
}
