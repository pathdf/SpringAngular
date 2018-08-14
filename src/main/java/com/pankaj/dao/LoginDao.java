package com.pankaj.dao;

import com.pankaj.model.LoginUser;

public interface LoginDao {

	LoginUser getUser(String username, String password);
	
	LoginUser getUser(String username);
	
	void update(LoginUser user);
}
