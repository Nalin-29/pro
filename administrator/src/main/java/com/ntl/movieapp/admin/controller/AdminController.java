package com.ntl.movieapp.admin.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntl.movieapp.admin.model.Movie;
import com.ntl.movieapp.admin.service.AdminService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class AdminController {
	
	@Autowired
	AdminService service;
	


	public AdminController() {
		super();
	}



	public AdminController(AdminService serve) {
		super();
		service=serve;
	}

    @GetMapping("/getAllMovie")
    public List<Movie> getAllMovie(){
    	return service.getAllMovie();
    }

	@GetMapping("/searches/title/{title}")
	public List<Movie> searchListByTitle(@PathVariable("title") String title){
		return service.allMoviesByTitle(title);
	}
	
	@GetMapping("/searches/category/{category}")
	public List<Movie> searchListBycategory(@PathVariable("category") String category){
		return service.allMoviesByCategory(category);
	}
	
	@GetMapping("/searches/language/{language}")
	public List<Movie> searchListByLanguage(@PathVariable("language") String language){
		System.out.println("Hii");
		return service.allMoviesByLanguage(language);
	}
	
	@PostMapping("/addMovie")
	public Movie register(@RequestBody Movie movie) {
		return service.addMovie(movie);
	}
	
	@PostMapping("editMovie")
	public Movie editMovie(@RequestBody Movie movie) {
	     
		return service.editMovie(movie);
	}
	
	@GetMapping("viewMovie/{movieId}")
	public Optional<Movie>  viewMovie(@PathVariable("movieId") int movieId) {
		
		return service.viewMovie(movieId);
	}
	
	@PostMapping("deleteMovie/{movieId}")
	public int deleteMovie(@PathVariable("movieId") int movieId) {
		System.out.println("delete movie called" + movieId);
		return service.deleteMovie(movieId);
	}
		
	@GetMapping("search/{list}")
	public List<Movie> searchFavList(@PathVariable("list") String list){
    System.out.println("Vibhanshu");

	List<Integer> listing=new ArrayList();

	String[] splittedList=list.split(",");
	for(int u=0;u<splittedList.length;u++)
	{
	listing.add(Integer.parseInt(splittedList[u])); 
	}

		List<Movie> listOfMovie;
	    System.out.println("List of IDS for final processing - " +listing.size());
		listOfMovie= service.allMoviesById(listing);
	    System.out.println("Final Output size -" + listOfMovie.size());
	return listOfMovie;

	}

	
}
