package com.ntl.movieapp.login.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntl.movieapp.login.movies.dao.CredentialsDao;
import com.ntl.movieapp.login.movies.model.CredentialsBean;


@Service
public class CredentialsService {
	
	@Autowired
	CredentialsDao credDao;
	
	CredentialsBean credentialsBean=new CredentialsBean();
	
	
	public CredentialsService() {
		super();
		
	}


	public CredentialsService(CredentialsDao credDao) {
		this.credDao=credDao;
	}
	
	
	
	
	public boolean authenticate(CredentialsBean credential) {
		credentialsBean = credDao.getOne(credential.getUserID());
		if(credentialsBean.getPassword().equals(credential.getPassword()))
			return true;
		else 
			return false;
 }




	public boolean changeLoginStatus(CredentialsBean credential, int loginStatus) {
		CredentialsBean credentials=new CredentialsBean();
		credentials=credDao.getOne(credential.getUserID());
		if(credentials.getLoginStatus()==credential.getLoginStatus()) {
			credentials.setLoginStatus(loginStatus);
			credDao.deleteById(credential.getUserID());
			credDao.save(credentials);
			return true;
		}
		else
			return false;

	}


	public CredentialsBean login(CredentialsBean credential) {
		boolean result=	authenticate(credential);
				if(result) {
					changeLoginStatus(credential, 1);
					credential.setPassword(null);
					return credential;
					}
				else
					return null;
				}
	
	public CredentialsBean forgotPassword(CredentialsBean credentials) {
		credentialsBean = credDao.getOne(credentials.getUserID());
		if(credentialsBean.getAuthQuestion().equals(credentials.getAuthQuestion()) && credentialsBean.getAuthAnswer().equals(credentials.getAuthAnswer())) {
			credentialsBean.setPassword(credentials.getPassword());
			credDao.saveAndFlush(credentialsBean);
			credentialsBean.setPassword(null);
			credentialsBean.setAuthQuestion(null);
			credentialsBean.setAuthAnswer(null);
			return credentialsBean;
		}
		else
			return null;
		
		}


	public boolean logout(String userId) {
		CredentialsBean credentials =credDao.getOne(userId);
		boolean stat=changeLoginStatus(credentials, 0);
			if(stat) 
				return true;
			else
				return false;
		}
	}
