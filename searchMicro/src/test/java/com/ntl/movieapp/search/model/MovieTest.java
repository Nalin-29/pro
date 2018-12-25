package com.ntl.movieapp.search.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class MovieTest
{

	String stdate="12/11/2015";
	String startd[]=stdate.split("/");
	LocalDate dt=LocalDate.of(Integer.parseInt(startd[2]),Integer.parseInt(startd[1]), Integer.parseInt(startd[0]));
	
	Movie move=new Movie(1,"kal ho na ho","image.jpg",dt,"this is a drama");
	
	
	
	@Test
	public void testGetMovieId() 
	{
		assertEquals(1,move.getMovieId());
	}

	@Test
	public void testSetMovieId() 
	{
		move.setMovieId(2);
		assertEquals(2,move.getMovieId());
	}

	@Test
	public void testGetMovieName() {
		assertEquals("kal ho na ho",move.getMovieName());
	}

	@Test
	public void testSetMovieName() {
		move.setMovieName("nayak");
		assertEquals("nayak",move.getMovieName());
	}

	@Test
	public void testGetMoviePosterUrl() {
		assertEquals("image.jpg",move.getMoviePosterUrl());
	}

	@Test
	public void testSetMoviePosterUrl() {
		move.setMoviePosterUrl("newimage.jpg");
		assertEquals("newimage.jpg",move.getMoviePosterUrl());
	}

	@Test
	public void testGetMovieReleaseDate() {
		assertEquals(dt,move.getMovieReleaseDate());
	}

	@Test
	public void testSetMovieReleaseDate() {

		String stdate="12/11/2016";
		String startd[]=stdate.split("/");
		LocalDate dat=LocalDate.of(Integer.parseInt(startd[2]),Integer.parseInt(startd[1]), Integer.parseInt(startd[0]));

		move.setMovieReleaseDate(dat);
		assertEquals(dat,move.getMovieReleaseDate());
	}

	@Test
	public void testGetMovieDescription() {
		assertEquals("this is a drama",move.getMovieDescription());
	}

	@Test
	public void testSetMovieDescription() {
		move.setMovieDescription("this is comedy");
		assertEquals("this is comedy",move.getMovieDescription());
	}


	
}
