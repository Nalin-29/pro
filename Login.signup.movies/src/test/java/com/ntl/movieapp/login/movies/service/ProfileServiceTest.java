package com.ntl.movieapp.login.movies.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ntl.movieapp.login.movies.controller.ProfileController;
import com.ntl.movieapp.login.movies.dao.CredentialsDao;
import com.ntl.movieapp.login.movies.dao.ProfileDao;
import com.ntl.movieapp.login.movies.model.CredentialsBean;
import com.ntl.movieapp.login.movies.model.ProfileBean;

@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest {
	@Mock
	ProfileDao profileDao;
	@Mock
	CredentialsDao credDao;
	
	CredentialsBean credentialsBean=new CredentialsBean("bhuvan223","Nangal@1",0);
	ProfileBean profile=new ProfileBean("bhuvan","bhuvan","dhand","9663589570","bhuvan223@gmail.com","Nand@1");
	//ProfileService  profileController=new ProfileService(profileDao);
	ProfileService  profileController1=new ProfileService(profileDao,credDao);

	@Test
	public void testRegister() {
		
		profile.setAuthAnswer("");
		profile.setAuthQuestion("");
		profile.setPassword("");
		//when(credDao.save(credentialsBean)).thenReturn(credentialsBean);
		//when(profileDao.save(profile)).thenReturn(profile);
		ProfileService serve=new ProfileService(profileDao,credDao);
		ProfileBean cred = serve.register(profile);

		assertEquals(cred,profile);
		//fail("Not yet implemented");
	}

}
