/**
 * 
 * 
 * 
 * 
 */

package com.ntl.movieapp.login.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_credentials")
public class CredentialsBean {
	
	@Id
	@Column(name="userid")
	private String userID;
	@Column(name="password")
	private String password;
	@Column(name="loginstatus")
	private int loginStatus;
	@Column(name="AuthQuestion")
	private String authQuestion;
	@Column(name="AuthAnswer")
	private String authAnswer;
	
	
	public CredentialsBean() {
		super();
	}



	/**
	 * @param userID
	 * @param password
	 * @param loginStatus
	 */
	public CredentialsBean(String userID, String password, int loginStatus) {
		super();
		this.userID = userID;
		this.password = password;
		this.loginStatus = loginStatus;
	}

	
	public String getAuthQuestion() {
		return authQuestion;
	}



	public void setAuthQuestion(String authQuestion) {
		this.authQuestion = authQuestion;
	}



	public String getAuthAnswer() {
		return authAnswer;
	}



	public void setAuthAnswer(String authAnswer) {
		this.authAnswer = authAnswer;
	}



	

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getLoginStatus() {
		return loginStatus;
	}


	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	
}
