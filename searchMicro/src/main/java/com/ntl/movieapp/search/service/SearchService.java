package com.ntl.movieapp.search.service;


import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ntl.movieapp.search.dao.SearchDao;
import com.ntl.movieapp.search.model.Movie;
import com.ntl.movieapp.search.model.SearchHistory;


@Service
public class SearchService {
	
	@Autowired
	public SearchDao dao;
	
	

	public SearchService() {
		super();
	}

	public SearchService(SearchDao dao) {
		super();
		this.dao=dao;
	}

	public SearchHistory addSearch(SearchHistory search) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		search.setSearchTime(timestamp);
		return dao.save(search);
	}

	public int deleteSearchHistory(int searchId) {
		try {
			dao.deleteById(searchId);
			return 1;
		}
		catch(Exception e) {
			return 0;
		}
	}

	public Optional<SearchHistory> viewSearchHistoryBySearchId(int searchId) {
		return dao.findById(searchId);
	}

	public List<SearchHistory> viewSearchHistoryByUserId(String userId) {
		return dao.findAllByUserId(userId);
	}

	public List<SearchHistory> viewAllSearchHistory() {
		return dao.findAll();
	}

	public List<SearchHistory> viewSearchHistoryByDate(String date) {
	  return dao.findAllBySearchDay(date);
	}

	public List<SearchHistory> viewSearchHistoryByDateAndUserId(String date, String userId) {
		return dao.findAllBySearchDateAndUserId(date,userId);
	}

	public List<SearchHistory> viewSearchHistoryByMovieId(int movieId) {
		return dao.findAllByMovieId(movieId);
	}

	public List<SearchHistory> viewSearchHistoryByDateAndMovieId(String date, int movieId) {
		return dao.findAllBySearchDateAndMovieId(date,movieId);
	}

	public List<SearchHistory> viewSearchHistoryByUserIdAndMovieId(String userId, int movieId) {
		return dao.findAllByUserIdAndMovieId(userId, movieId);
	}
	
}
