package com.ntl.movieapp.favourite.movies.model;

import static org.junit.Assert.*;

import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class FavouritesTest {

	Favourites favour=new Favourites(1,1,"ti8796","kal ho na ho","image.jpg","12/12/2018","this is good");
	
	
	@Test
	public void testGetFavouriteId() {
		assertEquals(1,favour.getFavouriteId());
	}

	@Test
	public void testSetFavouriteId() {
		favour.setFavouriteId(3);
		assertEquals(3,favour.getFavouriteId());
	}

	@Test
	public void testGetMovieId() {
		assertEquals(1,favour.getMovieId());
	}

	@Test
	public void testSetMovieId() {
		favour.setMovieId(2);
		assertEquals(2,favour.getMovieId());
	}

	@Test
	public void testGetUserId() {
		assertEquals("ti8796",favour.getUserId());
	}

	@Test
	public void testSetUserId() {
		favour.setUserId("Tr2234");
		assertEquals("Tr2234",favour.getUserId());
	}

	@Test
	public void testGetMovieName() {
		assertEquals("kal ho na ho",favour.getMovieName());
	}

	@Test
	public void testSetMovieName() {
		favour.setMovieName("nayak");
		assertEquals("nayak",favour.getMovieName());
	}

	@Test
	public void testGetMoviePosterUrl() {
		assertEquals("image.jpg",favour.getMoviePosterUrl());
	}

	@Test
	public void testSetMoviePosterUrl() {
		favour.setMoviePosterUrl("newimage.jpg");
		assertEquals("newimage.jpg",favour.getMoviePosterUrl());
	}

	@Test
	public void testGetMovieReleaseDate() {
		assertEquals("12/12/2018",favour.getMovieReleaseDate());
	}

	@Test
	public void testSetMovieReleaseDate() {
		favour.setMovieReleaseDate("11/11/2016");
		assertEquals("11/11/2016",favour.getMovieReleaseDate());
	}

}
