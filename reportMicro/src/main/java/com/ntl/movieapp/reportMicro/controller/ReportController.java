package com.ntl.movieapp.reportMicro.controller;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntl.movieapp.reportMicro.model.MovieUserView;
import com.ntl.movieapp.reportMicro.model.MovieView;
import com.ntl.movieapp.reportMicro.service.ReportService;

@CrossOrigin
@RestController
public class ReportController {

	@Autowired
	ReportService service;
	
	@GetMapping("/getUserViewMovie")
	public List<MovieUserView> getUserViewMovie(){
		return service.getUserViewMovie();
	}
	
	@GetMapping("/getViewsByMovie")
	public List<MovieView> getViewsByMovie(){
		List<Object> arr = service.getViewsByMovie();
		List<MovieView> movieList  = new ArrayList<MovieView>();
		for(Object o : arr) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				String jsonInString = mapper.writeValueAsString(o);
				String strr = jsonInString.substring(1, jsonInString.length()-1);
				String[] values = strr.split(",");
				MovieView obj = new MovieView();
				obj.setMovieId(Integer.parseInt(values[0]));
				obj.setMovieViews(Integer.parseInt(values[1]));
				movieList.add(obj);
			} 
			catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return  movieList;
	}
}
