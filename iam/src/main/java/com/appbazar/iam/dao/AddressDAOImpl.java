package com.appbazar.iam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.appbazar.iam.entity.Address;
import com.appbazar.iam.framework.AddressDAO;

public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public long addAddress(Address address) {

		template.save(address);
		return address.getAddrId();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAddress(Address address) {

		List<Address> listAddress = (List<Address>) template.find("from Address where addrId = ?", address.getAddrId());

		return listAddress;
	}

	public void updateUser(Address address) {

		template.update(address);
	}

	public void deleteUser(Address address) {
		template.delete(address);

	}

}
