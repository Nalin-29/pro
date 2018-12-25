package com.ntl.movieapp.reportMicro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntl.movieapp.reportMicro.model.MovieView;
import com.ntl.movieapp.reportMicro.model.SearchHistory;

@Repository
public interface ReportDao extends JpaRepository<SearchHistory,Integer>{
	
	 @Transactional
	 @Modifying
	 @Query(value = "select s.movie_id,count(*) as movie_views  from search_history as s where s.search_time > ? group by s.movie_id;", 
	   nativeQuery = true)
	 public List<Object> getMovieViews(String date);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "select movie_id from search_history where search_time > ?  group by movie_id", 
	   nativeQuery = true)
	 public List<Integer> getUserViewMovie(String date);
	
	 
	 @Transactional
	 @Modifying
	 @Query(value = "select distinct (user_id)  from search_history where movie_id = ? and search_time > ?", 
	   nativeQuery = true)
	 public List<String> getUsersFromMovieId(int movieId, String date);
	
}
