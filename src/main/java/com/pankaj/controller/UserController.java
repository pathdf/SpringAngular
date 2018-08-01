package com.pankaj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.model.User;
import com.pankaj.service.UserService;

@CrossOrigin
@RestController
@RequestMapping({ "/api" })
@Transactional
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = { "/add", "/update" }, method = RequestMethod.POST)
	public void saveOrUpdateUser(@RequestBody User user) {
		System.out.println("hello");
		userService.saveOrUpdateUser(user);
	}

	@RequestMapping(path = "/find/{id}", method = RequestMethod.GET)
	public User userDetailsById(@PathVariable("id") String userId) {
		Long id = Long.parseLong(userId);
		return userService.getUserById(id);
	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public void delteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}
}
