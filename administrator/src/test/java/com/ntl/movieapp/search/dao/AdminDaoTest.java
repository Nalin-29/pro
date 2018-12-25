package com.ntl.movieapp.search.dao;
import static org.junit.Assert.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntl.movieapp.admin.dao.AdminDao;
import com.ntl.movieapp.admin.model.Movie;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminDaoTest {
	
	@Mock
	AdminDao dao;
	
	String stdate="12/11/2015";
	String startd[]=stdate.split("/");
	LocalDate dt=LocalDate.of(Integer.parseInt(startd[2]),Integer.parseInt(startd[1]), Integer.parseInt(startd[0]));
	
	Movie move=new Movie(1,"kal ho na ho","jkbjb",dt,"kjbhjub");
	
	@Test
	public void findMoviesTest() {
		
		List<Movie> listing=new ArrayList<>();
		
		
		listing=dao.findMoviesByTitle("kal");
		
		assertEquals(0,listing.size());
	}

}
