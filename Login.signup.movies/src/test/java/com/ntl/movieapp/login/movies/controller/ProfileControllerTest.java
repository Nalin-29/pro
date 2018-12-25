package com.ntl.movieapp.login.movies.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ntl.movieapp.login.movies.model.CredentialsBean;
import com.ntl.movieapp.login.movies.model.ProfileBean;
import com.ntl.movieapp.login.movies.service.CredentialsService;
import com.ntl.movieapp.login.movies.service.ProfileService;
@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {
	ProfileBean pro=new ProfileBean();
	ProfileBean profile=new ProfileBean("bhuvan","bhuvan","dhand","9663589570","bhuvan223@gmail.com","Nand@1");

	@Mock
	ProfileService serve;
	ProfileController profileController=new ProfileController();
	@Test
	public void testProfileController() {
		//fail("Not yet implemented");
	}



	@Test
	public void testRegister() {
		when(serve.register(profile)).thenReturn(profile);
		ProfileController creden=new ProfileController(serve);
		pro=creden.register(profile);
		assertEquals(pro,profile);
		//assertEquals(credentials,cred);		//fail("Not yet implemented");
	}

}
