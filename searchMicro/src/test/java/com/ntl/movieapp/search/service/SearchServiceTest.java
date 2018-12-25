package com.ntl.movieapp.search.service;


import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ntl.movieapp.search.dao.SearchDao;
import com.ntl.movieapp.search.model.Movie;
import com.ntl.movieapp.search.model.SearchHistory;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {
	
	@Mock
	public SearchDao dao;

	
	String stdate="12/11/2015";
	String startd[]=stdate.split("/");
	LocalDate dt=LocalDate.of(Integer.parseInt(startd[2]),Integer.parseInt(startd[1]), Integer.parseInt(startd[0]));
	

	Movie move=new Movie(5,"ishanya","jkbjb",dt,"kjbhjub");
	
	  Calendar cal = Calendar.getInstance();
	SearchHistory history=new SearchHistory(1,"Ti2345",1);
	
	SearchService serach=new SearchService();
	
	@Test
	public void testAddSearch() {
		SearchHistory hiss=new SearchHistory();
		when(dao.save(history)).thenReturn(history);
		SearchService serve=new SearchService(dao);
		hiss=serve.addSearch(history);
		assertEquals(history.getMovieId(),hiss.getMovieId());
		
	}
	
	@Test
	public void testDeleteSearchHistory() {
		Mockito.lenient().doNothing().when(dao);
		SearchService serve=new SearchService(dao);
		int rel=serve.deleteSearchHistory(1);
		assertEquals(1,rel);
	}
	
	@Test
	public void testViewSearchHistoryBySearchId() {
		Optional<SearchHistory> hiss=null;
		when(dao.findById(1)).thenReturn(Optional.of(history));
		SearchService serve=new SearchService(dao);
		hiss=serve.viewSearchHistoryBySearchId(1);
		assertEquals(true,hiss.isPresent());
	}
	
	@Test
	public void testViewSearchHistoryByUserId() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(dao.findAllByUserId("Ti2345")).thenReturn(listing);
		SearchService serve=new SearchService(dao);
		listing=serve.viewSearchHistoryByUserId("Ti2345");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testViewAllSearchHistory() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(dao.findAll()).thenReturn(listing);
		SearchService serve=new SearchService(dao);
		listing=serve.viewAllSearchHistory();
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testViewSearchHistoryByDate() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(dao.findAllBySearchDay("2018-12-12")).thenReturn(listing);
		SearchService serve=new SearchService(dao);
		listing=serve.viewSearchHistoryByDate("2018-12-12");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testViewSearchHistoryByDateAndUserId() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(dao.findAllBySearchDateAndUserId("2018-12-12","Ti2345")).thenReturn(listing);
		SearchService serve=new SearchService(dao);
		listing=serve.viewSearchHistoryByDateAndUserId("2018-12-12","Ti2345");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testViewSearchHistoryByMovieId() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(dao.findAllByMovieId(1)).thenReturn(listing);
		SearchService serve=new SearchService(dao);
		listing=serve.viewSearchHistoryByMovieId(1);
		assertEquals(1,listing.size());
	}
	
	
	@Test
	public void testViewSearchHistoryByDateAndMovieId() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(dao.findAllBySearchDateAndMovieId("2018-12-12",1)).thenReturn(listing);
		SearchService serve=new SearchService(dao);
		listing=serve.viewSearchHistoryByDateAndMovieId("2018-12-12",1);
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testViewSearchHistoryByUserIdAndMovieId() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(dao.findAllByUserIdAndMovieId("Ti2345",1)).thenReturn(listing);
		SearchService serve=new SearchService(dao);
		listing=serve.viewSearchHistoryByUserIdAndMovieId("Ti2345",1);
		assertEquals(1,listing.size());
	}
	
//	@Test
//	public void testAllMoviesByTitle() {
//	
//		
//		ArrayList<Movie> listing=new ArrayList();
//		listing.add(move);
//		
//		when(dao.findMovies("kal")).thenReturn(listing);
//		SearchService serve=new SearchService(dao);
//
//		List<Movie> listingg=new ArrayList();
//		listingg.add(move);
//		listingg=serve.allMoviesByTitle("kal");
//		
//		assertEquals(1,listingg.size());
//
//	
//		
//	}
//
//	@Test
//	public void testAllMoviesById() {
//		List<Integer> listOfId=new ArrayList();
//		listOfId.add(1);
//		
//		List<Movie> listing=new ArrayList();
//		listing.add(move);
//		
//		when(dao.findAllById(listOfId)).thenReturn(listing);
//		
//	
//		
//		SearchService serve=new SearchService(dao);
//		listing= serve.allMoviesById(listOfId);
//		assertEquals(1,listing.size());
//	}

}
