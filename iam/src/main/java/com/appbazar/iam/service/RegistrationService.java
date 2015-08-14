package com.appbazar.iam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.appbazar.iam.dao.AddressDAOImpl;
import com.appbazar.iam.dao.RegistrationDAOImpl;
import com.appbazar.iam.entity.User;
import com.appbazar.iam.framework.RegistrationServiceIntf;

@Transactional
public class RegistrationService implements RegistrationServiceIntf {

	@Autowired
	private RegistrationDAOImpl regDAO;

	public void setRegDAO(RegistrationDAOImpl regDAO) {
		this.regDAO = regDAO;
	}
	
	@Autowired
	private AddressDAOImpl addrDAO;

		
	public void setAddrDAO(AddressDAOImpl addrDAO) {
		this.addrDAO = addrDAO;
	}

	@Override
	public long registerUser(User user) {
		
		return regDAO.addUser(user); 
		
	
	}

	@Override
	public List<User> getAllUsers() {

		return regDAO.getAllUsers();
	}

	@Override
	public List<User> getUser(User user) {

		return regDAO.getUser(user);
	}

	@Override
	public void updateUser(User user) {
		regDAO.updateUser(user);

	}

	@Override
	public void deleteUser(User user) {

		regDAO.deleteUser(user);
	}

}
