package com.appbazar.iam.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appbazar.iam.entity.User;
import com.appbazar.iam.service.RegistrationService;

@RestController
@RequestMapping("/user")
public class RegistrationController {

	@Autowired
	private RegistrationService regService;

	

	public void setRegService(RegistrationService regService) {
		this.regService = regService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public long registerUser(@RequestBody User user) {

		return regService.registerUser(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {

		return regService.getAllUsers();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public List<User> getUser(@PathVariable int userId) {

		User user = new User();
		user.setUserId(userId);
		return regService.getUser(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user , @PathVariable int userId) {
		
		user.setUserId(userId);
		regService.updateUser(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody User user , @PathVariable int userId) {

	//	User user = new User();
		user.setUserId(userId);
		System.out.println("delete");
		regService.deleteUser(user);
	}

}
