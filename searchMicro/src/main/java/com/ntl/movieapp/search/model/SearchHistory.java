package com.ntl.movieapp.search.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchHistory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int searchId;
	private String userId;
	private int movieId;
	private Timestamp searchTime;
	
	public SearchHistory()
	{
		super();
	}
	
	public SearchHistory(int searchId, String userId, int movieId) 
	{
		super();
		this.searchId = searchId;
		this.userId = userId;
		this.movieId = movieId;
		
	}
	/**
	 * @return the searchId
	 */
	public int getSearchId()
	{
		return searchId;
	}
	/**
	 * @param searchId the searchId to set
	 */
	public void setSearchId(int searchId)
	{
		this.searchId = searchId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
	/**
	 * @return the movieId
	 */
	public int getMovieId() 
	{
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId)
	{
		this.movieId = movieId;
	}
	/**
	 * @return the searchTime
	 */
	public Timestamp getSearchTime() 
	{
		return searchTime;
	}
	/**
	 * @param searchTime the searchTime to set
	 */
	public void setSearchTime(Timestamp searchTime)
	{
		this.searchTime = searchTime;
	}
	
	
}
