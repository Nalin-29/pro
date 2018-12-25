package com.ntl.movieapp.search.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ntl.movieapp.search.model.Movie;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface SearchMoviesProxy {
	
	@GetMapping("administrator/searches/title/{title}")
	public List<Movie> searchMoviesByTitle
	(@PathVariable("title") String title);
	
	
	@GetMapping("administrator/searches/category{category}")
	public List<Movie> searchMoviesByCategory
	(@PathVariable("category") String category);
	
	
	@GetMapping("administrator/searches/language/{language}")
	public List<Movie> searchMoviesByLanguage
	(@PathVariable("language") String language);

}
