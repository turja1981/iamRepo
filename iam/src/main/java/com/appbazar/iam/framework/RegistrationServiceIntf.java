package com.appbazar.iam.framework;

import java.util.List;

import com.appbazar.iam.entity.User;

public interface RegistrationServiceIntf {

	long registerUser(User user);

	List<User> getAllUsers();

	List<User> getUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

}
