package com.appbazar.iam.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.appbazar.iam.entity.Address;
import com.appbazar.iam.entity.User;
import com.appbazar.iam.framework.RegistrationDAO;

public class RegistrationDAOImpl implements RegistrationDAO {

	@Autowired
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public long addUser(User user) {

		template.save(user);
		
		for (Address address :user.getAddress())
		{
			address.setUserforeign(user);
			template.save(address);
		}
		
		return user.getUserId();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {

		List<User> listUser = (List<User>) template.find("from User");

		return listUser;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUser(User user) {

		List<User> listUser = (List<User>) template.find("from User  where userId = ?", user.getUserId());
		
		List<Address> listAddress= (List<Address>) template.find("from Address  where userforeign = ?", user);
		
		System.out.println("-------"+listAddress.size());
		
		listUser.get(0).setAddress(listAddress);

		return listUser;
	}

	public void updateUser(User user) {

		template.update(user);
	}

	public void deleteUser(User user) {
		System.out.println("dao delete:" + user.getUserId());
		
		template.delete(user , LockMode.PESSIMISTIC_WRITE );
		
		
	}

}
