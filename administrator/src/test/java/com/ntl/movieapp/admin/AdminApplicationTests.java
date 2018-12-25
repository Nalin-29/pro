package com.ntl.movieapp.admin;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import org.junit.runner.RunWith;

import com.ntl.movieapp.admin.controller.AdminController;
import com.ntl.movieapp.search.controller.AdminControllerTest;
import com.ntl.movieapp.search.dao.AdminDaoTest;
import com.ntl.movieapp.search.model.MovieTest;
import com.ntl.movieapp.search.service.AdminServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AdminControllerTest.class,
	AdminServiceTest.class,
	AdminDaoTest.class,
	MovieTest.class
	
})
public class AdminApplicationTests {
	
	 @Autowired
	 private AdminController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
