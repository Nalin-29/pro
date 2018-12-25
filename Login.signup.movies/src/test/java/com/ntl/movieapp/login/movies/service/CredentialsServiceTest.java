package com.ntl.movieapp.login.movies.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import com.ntl.movieapp.login.movies.dao.CredentialsDao;
import com.ntl.movieapp.login.movies.model.CredentialsBean;
@RunWith(MockitoJUnitRunner.class)
public class CredentialsServiceTest {
	@Mock
	CredentialsDao credDao;
	CredentialsBean credentials=new CredentialsBean("","",0);
	CredentialsBean credentialsBean=new CredentialsBean("bhuvan223","Nangal@1",0);
	
	
	CredentialsService creialsSer=new CredentialsService();
	CredentialsService creialsservice=new CredentialsService(credDao);

	@Test
	public void testAuthenticate() {
		when(credDao.getOne("bhuvan223")).thenReturn(credentialsBean);
		CredentialsService serve=new CredentialsService(credDao);
		boolean result = serve.authenticate(credentialsBean);
		assertEquals(true,result);
		
		CredentialsBean credentialsBean2=new CredentialsBean("bhuvan223","Nngal@1",0);
		boolean result2 =serve.authenticate(credentialsBean2);
		assertEquals(false,result2);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testChangeLoginStatus() {
		when(credDao.getOne("bhuvan223")).thenReturn(credentialsBean);
		CredentialsService serve=new CredentialsService(credDao);
		boolean result = serve.changeLoginStatus(credentialsBean,0);
		assertEquals(true,result);
		
		CredentialsBean credentialsBean2=new CredentialsBean("bhuvan223","Nngal@1",1);
		boolean result2 = serve.changeLoginStatus(credentialsBean2,1);
		assertEquals(false,result2);
		//fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		when(credDao.getOne("bhuvan223")).thenReturn(credentialsBean);
		CredentialsService serve=new CredentialsService(credDao);
		CredentialsBean cred = serve.login(credentialsBean);
		assertEquals(cred,credentialsBean);
	
	}
	@Test
	public void testForgotPassword() {
		credentialsBean.setAuthAnswer("");
		credentialsBean.setAuthQuestion("");
		when(credDao.getOne("bhuvan223")).thenReturn(credentialsBean);
		CredentialsService serve=new CredentialsService(credDao);
		CredentialsBean cred = serve.forgotPassword(credentialsBean);
		assertEquals(cred,credentialsBean);
		
//		CredentialsBean credentialsBean2=new CredentialsBean("bhuvan22","Nangal@1",0);
//		credentialsBean2.setAuthAnswer("Who is this");
//		credentialsBean2.setAuthQuestion("What is this");
//
//	CredentialsBean cred2 = serve.forgotPassword(credentialsBean2);
//	assertNull(cred2);
		//fail("Not yet implemented");
	}

	@Test
	public void testLogout() {
		when(credDao.getOne("bhuvan223")).thenReturn(credentialsBean);
		CredentialsService serve=new CredentialsService(credDao);
		boolean result=serve.logout("bhuvan223");
		assertEquals(true,result);
		
	}

}
