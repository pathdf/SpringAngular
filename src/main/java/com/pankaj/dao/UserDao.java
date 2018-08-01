package com.pankaj.dao;

import java.util.List;

import com.pankaj.model.User;

public interface UserDao {

	User getUserById(Long id);

	User saveOrUpdateUser(User user);

	List<User> getAllUser();

	User deleteUser(User user);
}
