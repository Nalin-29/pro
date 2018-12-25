package com.ntl.movieapp.search;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import org.junit.runner.RunWith;

import com.ntl.movieapp.search.controller.SearchController;
import com.ntl.movieapp.search.controller.SearchControllerTest;

import com.ntl.movieapp.search.model.MovieTest;
import com.ntl.movieapp.search.service.SearchServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	SearchControllerTest.class,
	SearchServiceTest.class,
	MovieTest.class
	
})
public class SearchApplicationTests {
	
	 @Autowired
	 private SearchController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
