package com.pankaj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.dao.UserDao;
import com.pankaj.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	
	public void saveOrUpdateUser(User user) {
		userDao.saveOrUpdateUser(user);

	}

	
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	
	public void deleteUser(User user) {

		userDao.deleteUser(user);
	}

}
