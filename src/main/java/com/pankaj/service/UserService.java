package com.pankaj.service;

import java.util.List;

import com.pankaj.model.User;

public interface UserService {

	User getUserById(Long id);
	
	void saveOrUpdateUser(User user);
	
	List<User> getAllUser();
	
	void deleteUser(User user);
}
