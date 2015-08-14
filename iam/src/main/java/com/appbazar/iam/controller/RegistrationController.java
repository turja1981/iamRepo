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
import com.appbazar.iam.framework.RegistrationServiceIntf;

@RestController
@RequestMapping("/user")
public class RegistrationController {

	@Autowired
	private RegistrationServiceIntf service;

	public void setService(RegistrationServiceIntf service) {
		this.service = service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public long registerUser(@RequestBody User user) {
		System.out.println("test");
		System.out.println(user.getName());
	
		System.out.println(user.getEmail());
		user.setCreatedBy(user.getMobileNo());
		user.setUpdatedBy(user.getMobileNo());
		user.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		user.setUpdatedOn(new Timestamp(new java.util.Date().getTime()));
		return service.registerUser(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {

		return service.getAllUsers();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public List<User> getUser(@PathVariable int userId) {

		User user = new User();
		user.setUserId(userId);
		return service.getUser(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user , @PathVariable int userId) {
		
		user.setUserId(userId);
		service.updateUser(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody User user , @PathVariable int userId) {

	//	User user = new User();
		user.setUserId(userId);
		System.out.println("delete");
		service.deleteUser(user);
	}

}
