package com.ntl.movieapp.favourite.movies.service;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.ntl.movieapp.favourite.movies.dao.FavDao;
import com.ntl.movieapp.favourite.movies.model.Favourites;

@RunWith(MockitoJUnitRunner.class)
public class FavServiceTest {

	@Mock
	FavDao dao;
	
	FavService serv=new FavService();
	
		FavService ser=new FavService(dao);
	
	Favourites favour=new Favourites(1,1,"ti8796","kal ho na ho","image.jpg","12/12/2018","this is good");
	Favourites favrt=new Favourites(1,"ti8796");
	
	@Test
	public void testFavouriteListAllMovies() {
		
		List<Favourites> fav=new ArrayList();
		fav.add(favour);
		
		List<Integer> listOfId=new ArrayList();
		listOfId.add(1);
		
		when(dao.findAll()).thenReturn(fav);
		FavService ser=new FavService(dao);
		listOfId=ser.favouriteListAllMovies();
		assertEquals(1,listOfId.size());
	}

	@Test
	public void testFavouriteListAddition() {

		Mockito.lenient().when(dao.save(favrt)).thenReturn(favrt);
		FavService ser=new FavService(dao);
		favrt=ser.favouriteListAddition(favrt.getMovieId());
		assertEquals(1,favrt.getMovieId());
	}
	
	@Test
	public void testFavouriteDelete() {
		when(dao.deleteByMovieId(1)).thenReturn(1);
		FavService ser=new FavService(dao);
		int res=ser.favouriteDelete(1);
		assertEquals(1,res);
	}

}
