package com.ntl.movieapp.favourite.movies.Controller;

import static org.junit.Assert.*;

import org.mockito.junit.MockitoJUnitRunner;

import com.ntl.movieapp.favourite.movies.controller.FavController;
import com.ntl.movieapp.favourite.movies.model.Favourites;
import com.ntl.movieapp.favourite.movies.proxy.FavListServiceProxy;
import com.ntl.movieapp.favourite.movies.service.FavService;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class FavControllerTest {

	@Mock
	FavService serve;
	
	@Mock
	FavListServiceProxy prox;
	
	FavController facontrol=new FavController();
	
	FavController favControlservice=new FavController(serve,prox);
	
	String stdate="12/11/2015";
	String startd[]=stdate.split("/");
	LocalDate dt=LocalDate.of(Integer.parseInt(startd[2]),Integer.parseInt(startd[1]), Integer.parseInt(startd[0]));
	
	Favourites favour=new Favourites(1,1,"ti8796","kal ho na ho","image.jpg","12/12/2018","this is good");
	
	@Test
	public void testFavouriteList() {
		List<Integer> listOfId=new ArrayList();
		listOfId.add(1);
		
		List<Favourites> fav=new ArrayList();
		fav.add(favour);
		
		when(serve.favouriteListAllMovies()).thenReturn(listOfId);
		when(prox.searchFavList("1")).thenReturn(fav);
		FavController control=new FavController(serve,prox);
		fav=control.favouriteList();
		assertEquals(1,fav.size());
	}

	@Test
	public void testAddToFavourites() {
		when(serve.favouriteListAddition(2)).thenReturn(favour);
		FavController control=new FavController(serve,prox);
		favour=control.addToFavourites(2);
		assertEquals(1,favour.getMovieId());
	}
	
	@Test
	public void testDelFavourite() {
		when(serve.favouriteDelete(1)).thenReturn(1);
		FavController control=new FavController(serve,prox);
		int rel=control.delFavourite(1);
		assertEquals(rel,1);
	}

}
