/*
 *Author:Ishanya
 *Date:22/11/2018
 *NIIT Tech. 
 */

package com.ntl.movieapp.search.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntl.movieapp.search.model.Movie;
import com.ntl.movieapp.search.model.SearchHistory;
import com.ntl.movieapp.search.proxy.SearchMoviesProxy;
import com.ntl.movieapp.search.service.SearchService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class SearchController
{
	
	@Autowired
	SearchService service;
	
	
	@Autowired
	SearchMoviesProxy searchProxy;


	public SearchController() 
	{
		super();
	}


	public SearchController(SearchService serve)
	{
		super();
		service=serve;
	}
	
	public SearchController(SearchMoviesProxy serve) 
	{
		super();
		searchProxy=serve;
	}

	@GetMapping("/searches/title/{title}")
	public List<Movie> searchListTitle(@PathVariable("title") String title)
	{
		return searchProxy.searchMoviesByTitle(title);
	}
		
	@GetMapping("/searches/category/{category}")
	public List<Movie> searchListCategory(@PathVariable("category") String category)
	{
		return searchProxy.searchMoviesByCategory(category);
	}
	
	@GetMapping("/searches/language/{language}")
	public List<Movie> searchListLanguage(@PathVariable("language") String language)
	{
		return searchProxy.searchMoviesByLanguage(language);	
	}
	
	@PostMapping("/addSearch")
	public SearchHistory addSearch(@RequestBody SearchHistory search) 
	{
		return service.addSearch(search);
	}
	
	@PostMapping("/deleteSearch/{searchId}")
	public int deleteSearch(@PathVariable("searchId") int searchId)
	{
		return service.deleteSearchHistory(searchId);
	}
	@GetMapping("/viewBySearchId/{searchId}")
	public Optional<SearchHistory> viewSearchHistoryBySearchId(@PathVariable("searchId") int searchId)
	{
		return service.viewSearchHistoryBySearchId(searchId);
	}
	
	@GetMapping("/viewByDate/{date}")
	public List<SearchHistory> viewSearchHistoryByDate(@PathVariable("date") String date)
	{
		return service.viewSearchHistoryByDate(date);
	}	
	
	@GetMapping("/viewByUserId/{userId}")
	public List<SearchHistory> viewSearchHistoryByUserId(@PathVariable("userId") String userId) {
		return service.viewSearchHistoryByUserId(userId);
	}
	
	@GetMapping("/viewByMovieId/{movieId}")
	public List<SearchHistory> viewSearchHistoryByMovieId(@PathVariable("movieId") int movieId)
	{
		return service.viewSearchHistoryByMovieId(movieId);
	}
	
	@GetMapping("/viewByDateAndUserId/{date}/{userId}")
	public List<SearchHistory> viewByDateAndUserId
	(@PathVariable("date") String date, @PathVariable("userId") String userId)
	{
		return service.viewSearchHistoryByDateAndUserId(date,userId);
	}
	@GetMapping("/viewByDateAndMovieId/{date}/{movieId}")
	public List<SearchHistory> viewByDateAndMovieId
	(@PathVariable("date") String date, @PathVariable("movieId") int movieId) {
		return service.viewSearchHistoryByDateAndMovieId(date,movieId);
	}

	@GetMapping("/viewByUserIdAndMovieId/{userId}/{movieId}")
	public List<SearchHistory> viewByUserIdAndMovieId
	(@PathVariable("userId") String userId, @PathVariable("movieId") int movieId)
	{
		return service.viewSearchHistoryByUserIdAndMovieId(userId,movieId);
	}
	
	@GetMapping("/viewAllSearches")
	public List<SearchHistory> viewAllSearchHistory() 
	{
		return service.viewAllSearchHistory();
	}
}
