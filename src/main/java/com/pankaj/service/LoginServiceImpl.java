package com.pankaj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.dao.LoginDao;
import com.pankaj.model.LoginUser;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	public LoginUser getUser(String username, String password) {
		return loginDao.getUser(username, password);
	}
	public void update(LoginUser user) {
		loginDao.update(user);
	}
	public LoginUser getUser(String username) {
		return loginDao.getUser(username);
	}

	
}
