package com.ntl.movieapp.search.controller;

import static org.junit.Assert.*;

import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.ntl.movieapp.search.model.Movie;
import com.ntl.movieapp.search.model.SearchHistory;
import com.ntl.movieapp.search.proxy.SearchMoviesProxy;
import com.ntl.movieapp.search.service.SearchService;


@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

	@Mock
	public SearchService serve;
	
	@Mock
	public SearchMoviesProxy proxy;
	
	SearchController con=new SearchController();
	
	String stdate="12/11/2015";
	String startd[]=stdate.split("/");
	LocalDate dt=LocalDate.of(Integer.parseInt(startd[2]),Integer.parseInt(startd[1]), Integer.parseInt(startd[0]));
	
	Movie move=new Movie(1,"ishanya","jkbjb",dt,"kjbhjub");
	
	SearchHistory history=new SearchHistory(1,"Ti2345",1);
	
	@Test
	public void testSearchListTitle() {
		
		List<Movie> listing=new ArrayList();
		listing.add(move);
		
		when(proxy.searchMoviesByTitle("kal")).thenReturn(listing);
		SearchController control=new SearchController(proxy);
		listing=control.searchListTitle("kal");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testSearchListCategory() {
		
		List<Movie> listing=new ArrayList();
		listing.add(move);
		
		when(proxy.searchMoviesByCategory("Horror")).thenReturn(listing);
		SearchController control=new SearchController(proxy);
		listing=control.searchListCategory("Horror");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testSearchListLanguage() {
		
		List<Movie> listing=new ArrayList();
		listing.add(move);
		
		when(proxy.searchMoviesByLanguage("Hindi")).thenReturn(listing);
		SearchController control=new SearchController(proxy);
		listing=control.searchListLanguage("Hindi");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testaddSearch() {
	
		
		when(serve.addSearch(history)).thenReturn(history);
		SearchController control=new SearchController(serve);
		history=control.addSearch(history);
		assertEquals("Ti2345",history.getUserId());
	}

	@Test
	public void testdeleteSearch() {
		when(serve.deleteSearchHistory(1)).thenReturn(1);
		SearchController control=new SearchController(serve);
		int rel=control.deleteSearch(1);
		assertEquals(1,rel);
	}

	@Test
	public void testviewSearchHistoryBySearchId() {
		Optional<SearchHistory> opt=null;
		when(serve.viewSearchHistoryBySearchId(1)).thenReturn(Optional.of(history));
		SearchController control=new SearchController(serve);
		opt=control.viewSearchHistoryBySearchId(1);
		assertEquals(true,opt.isPresent());
	}

	@Test
	public void testviewSearchHistoryByDate() {
	List<SearchHistory> listing=new ArrayList();
	listing.add(history);
		when(serve.viewSearchHistoryByDate("2018-12-12")).thenReturn(listing);
		SearchController control=new SearchController(serve);
		listing=control.viewSearchHistoryByDate("2018-12-12");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testviewSearchHistoryByUserId() {
	List<SearchHistory> listing=new ArrayList();
	listing.add(history);
		when(serve.viewSearchHistoryByUserId("2018-12-12")).thenReturn(listing);
		SearchController control=new SearchController(serve);
		listing=control.viewSearchHistoryByUserId("2018-12-12");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testviewSearchHistoryByMovieId() {
	List<SearchHistory> listing=new ArrayList();
	listing.add(history);
		when(serve.viewSearchHistoryByMovieId(1)).thenReturn(listing);
		SearchController control=new SearchController(serve);
		listing=control.viewSearchHistoryByMovieId(1);
		assertEquals(1,listing.size());
	}

	@Test
	public void testviewByDateandUserId() {
	List<SearchHistory> listing=new ArrayList();
	listing.add(history);
		when(serve.viewSearchHistoryByDateAndUserId("2018-12-12","Ti2345")).thenReturn(listing);
		SearchController control=new SearchController(serve);
		listing=control.viewByDateAndUserId("2018-12-12", "Ti2345");
		assertEquals(1,listing.size());
	}
	
	@Test
	public void testViewByDateandMovieId() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
			when(serve.viewSearchHistoryByDateAndMovieId("2018-12-12",1)).thenReturn(listing);
			SearchController control=new SearchController(serve);
			listing=control.viewByDateAndMovieId("2018-12-12", 1);
			assertEquals(1,listing.size());
	}
	
	@Test
	public void testViewByUserIdandMovieId() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
			when(serve.viewSearchHistoryByUserIdAndMovieId("Ti2345",1)).thenReturn(listing);
			SearchController control=new SearchController(serve);
			listing=control.viewByUserIdAndMovieId("Ti2345", 1);
			assertEquals(1,listing.size());
	}
	
	
	@Test
	public void TestViewAllSearchHistory() {
		List<SearchHistory> listing=new ArrayList();
		listing.add(history);
		when(serve.viewAllSearchHistory()).thenReturn(listing);
		SearchController control=new SearchController(serve);
		listing=control.viewAllSearchHistory();
		assertEquals(1,listing.size());
	}
	
//	@Test
//	public void testSearchFavList() {
//		List<Movie> listing=new ArrayList();
//		listing.add(move);
//		
//		List<Integer> listOfId=new ArrayList();
//		listOfId.add(1);
//		
//		when(serve.allMoviesById(listOfId)).thenReturn(listing);
//		SearchController control=new SearchController(serve);
//		
//		listing=control.searchFavList("1");
//		
//		assertEquals(1,listing.size());
//	}

}
