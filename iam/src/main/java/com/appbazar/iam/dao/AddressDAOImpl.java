package com.appbazar.iam.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.appbazar.iam.entity.Address;
import com.appbazar.iam.entity.User;
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
	public List<Address> findAddressByUser(User user) {

		List<Address> addressList = new ArrayList<Address>();
		addressList = (List<Address>) template.find("from Address where userforeign = ?", user);

		return addressList;
	}

	public List<User> getUserByAddress(Address address) {

		List<User> userList = new ArrayList<User>();

		StringBuilder query = new StringBuilder("from Address where ");
		boolean firstCondition = false;
		List<String> paramList = new ArrayList<String>();
		List<Object> valueList = new ArrayList<Object>();

		if (null != address.getCity()) {
			query.append(" city = :city");
			paramList.add("city");
			valueList.add(address.getCity());
			firstCondition = true;
		}

		if (null != address.getLocality()) {
			if (firstCondition) {
				query.append(" and ");
			}
			query.append(" locality = :locality");
			paramList.add("locality");
			valueList.add(address.getLocality());

		}

		if (null != address.getCountry()) {
			if (firstCondition) {
				query.append(" and ");

			}
			query.append(" country = :country");
			paramList.add("country");
			valueList.add(address.getCountry());

		}

		if (null != address.getZip()) {
			if (firstCondition) {
				query.append(" and ");
			}
			query.append(" zip = :zip");
			paramList.add("zip");
			valueList.add(address.getZip());
		}

		List<Address> listAddress = (List<Address>) template.findByNamedQuery(query.toString(), paramList.toArray(), valueList.toArray());

		for (Address dbAddress : listAddress) {
			userList.add(dbAddress.getUserforeign());
		}

		return userList;
	}

	
}
