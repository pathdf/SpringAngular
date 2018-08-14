package com.pankaj.bean;

import java.io.Serializable;

public class LoginUserBean implements Serializable{

	private Long id;
	private String userName;
	private String password;
	private Integer maxTries;
	private boolean loginStatus=true;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getMaxTries() {
		return maxTries;
	}
	public void setMaxTries(Integer maxTries) {
		this.maxTries = maxTries;
	}
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	
}
