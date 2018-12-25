package com.ntl.movieapp.favourite.movies.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntl.movieapp.favourite.movies.model.Favourites;
import com.ntl.movieapp.favourite.movies.proxy.FavListServiceProxy;
import com.ntl.movieapp.favourite.movies.service.FavService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class FavController {

	@Autowired
	FavService service;
	
	@Autowired
	FavListServiceProxy proxy;
	
	
	public FavController() {
		super();
	}


	public FavController(FavService serve, FavListServiceProxy prox) {
		super();
		service=serve;
		proxy=prox;
	}


	@GetMapping("/favourite")
	public List<Favourites> favouriteList() {
	List<Integer> listOfMovieid;
	listOfMovieid=service.favouriteListAllMovies();
	
	StringBuilder bld = new StringBuilder();
	for(Integer it:listOfMovieid) {
		bld.append(it);
		bld.append(",");
	}
	String listofId=bld.toString();
	String listOfIds=listofId.substring(0, listofId.length()-1);
	return  proxy.searchFavList(listOfIds);
	} 
	
	
	@PostMapping("/favAdd/{movieid}")
	public Favourites addToFavourites(@PathVariable("movieid") int movieid) {
		return service.favouriteListAddition(movieid);
	}
	
	@PutMapping("/favDelete/{movieid}")
	public int delFavourite(@PathVariable("movieid") int movieid){

		return service.favouriteDelete(movieid);
		
	}
}
