package com.ntl.movieapp.favourite.movies.proxy;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ntl.movieapp.favourite.movies.model.Favourites;

//@FeignClient(name="search-movies")
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface FavListServiceProxy {

	
	@GetMapping("/administrator/search/{list}")
	public List<Favourites> searchFavList
	(@PathVariable("list") String list);
	
	
	
}
