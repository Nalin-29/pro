package com.ntl.movieapp.favourite.movies;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ntl.movieapp.favourite.movies.Controller.FavControllerTest;
import com.ntl.movieapp.favourite.movies.controller.FavController;
import com.ntl.movieapp.favourite.movies.model.FavouritesTest;
import com.ntl.movieapp.favourite.movies.service.FavServiceTest;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	FavControllerTest.class,
	FavServiceTest.class,
	FavouritesTest.class
})
public class ApplicationTests {

	 @Autowired
	 private FavController controller;
	
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
