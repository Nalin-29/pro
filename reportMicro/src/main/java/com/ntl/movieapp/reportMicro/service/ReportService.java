package com.ntl.movieapp.reportMicro.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntl.movieapp.reportMicro.dao.ReportDao;
import com.ntl.movieapp.reportMicro.model.MovieUserView;
import com.ntl.movieapp.reportMicro.model.MovieView;

@Service
public class ReportService {

	@Autowired
	ReportDao dao;

	public List<Object> getViewsByMovie() {
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = now.minusDays(7);
        String v = then.format(format);
        return dao.getMovieViews(v);
		
	}

	public List<MovieUserView> getUserViewMovie() {
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = now.minusDays(7);
        String v = then.format(format);
        
        List<Integer> ar = dao.getUserViewMovie(v);
        List<MovieUserView> movieuserViewList = new ArrayList<MovieUserView>();
        for(Integer i : ar) {
        	List<String> userData = dao.getUsersFromMovieId(i, v);
        	for(String s : userData) {
        		MovieUserView movieUserView  = new MovieUserView();
        		movieUserView.setMovieId(i);
        		movieUserView.setUserId(s);
        		movieuserViewList.add(movieUserView);
        	}
        }
		return movieuserViewList;
	}
}
