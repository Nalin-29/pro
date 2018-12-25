package com.ntl.movieapp.admin.dao;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntl.movieapp.admin.model.Movie;

@Repository
public interface AdminDao extends JpaRepository<Movie, Integer>{

	public Optional<Movie> findByMovieName(String movieName);
	
	//findMoviesByCategory
	 @Transactional
	 @Modifying
	 @Query(value = "select * from movie  where movie_name like %?%", 
	   nativeQuery = true)
	 public List<Movie> findMoviesByTitle(String movieName);
	 
	 
	 @Transactional
	 @Modifying
	 @Query(value = "select * from movie  where movie_category like %?%", 
	   nativeQuery = true)
	 public List<Movie> findMoviesByCategory(String movieCategory);
	
	 @Transactional
	 @Modifying
	 @Query(value = "select * from movie  where movie_language like %?%", 
	   nativeQuery = true)
	 public List<Movie> findMoviesByLanguage(String movieLanguage);
}
