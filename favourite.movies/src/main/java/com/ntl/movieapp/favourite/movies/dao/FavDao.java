package com.ntl.movieapp.favourite.movies.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntl.movieapp.favourite.movies.model.Favourites;



@Repository
public interface FavDao extends JpaRepository<Favourites,Integer>{
	
	 @Transactional
	 @Modifying
	 @Query(value = "delete from favourites where movie_id=?", 
	   nativeQuery = true)
	 public int deleteByMovieId(int movieId);
	
}
