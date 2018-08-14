package com.pankaj.service;

import com.pankaj.model.LoginUser;

public interface LoginService {

	LoginUser getUser(String username, String password);
	
	void update(LoginUser user);
	
	LoginUser getUser(String username);
}
