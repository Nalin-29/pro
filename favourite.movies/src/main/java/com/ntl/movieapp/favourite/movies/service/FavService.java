package com.ntl.movieapp.favourite.movies.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntl.movieapp.favourite.movies.dao.FavDao;
import com.ntl.movieapp.favourite.movies.model.Favourites;

@Service
public class FavService {

	
	@Autowired
	FavDao dao;
	


	public FavService() {
		super();
	}


	public FavService(FavDao dao) {
		super();
		this.dao=dao;
	}

	
	public List<Integer> favouriteListAllMovies() {
		
		List<Favourites> listing;
		List<Integer> listOfId=new ArrayList();
		int movieid;
		 listing=dao.findAll();
		 for(Favourites fav:listing) {
			 movieid=fav.getMovieId();
			 listOfId.add(movieid);
		 }
		 
		return listOfId;
	}

	public Favourites favouriteListAddition(int movieid) {
		Favourites fav=new Favourites(movieid,"Yt9876");
		dao.save(fav);
		return fav;
	}
	
	public int favouriteDelete(int movieid) {
		
		int result=dao.deleteByMovieId(movieid);
		return result;
	}
	
}
