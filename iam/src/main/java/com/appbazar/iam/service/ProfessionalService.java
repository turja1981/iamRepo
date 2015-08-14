package com.appbazar.iam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appbazar.iam.dao.AddressDAOImpl;
import com.appbazar.iam.dao.RegistrationDAOImpl;
import com.appbazar.iam.dao.ServiceDAOImpl;
import com.appbazar.iam.dao.ServiceResponseDAOImpl;
import com.appbazar.iam.entity.Address;
import com.appbazar.iam.entity.Service;
import com.appbazar.iam.entity.ServiceResponse;
import com.appbazar.iam.entity.User;

public class ProfessionalService {

	@Autowired
	private RegistrationDAOImpl regDAO;

	@Autowired
	private ServiceDAOImpl serviceDAO;

	@Autowired
	private ServiceResponseDAOImpl serviceResponseDAO;

	@Autowired
	private AddressDAOImpl addressDAO;

	public void setRegDAO(RegistrationDAOImpl regDAO) {
		this.regDAO = regDAO;
	}

	public void setServiceDAO(ServiceDAOImpl serviceDAO) {
		this.serviceDAO = serviceDAO;
	}

	public void setAddressDAO(AddressDAOImpl addressDAO) {
		this.addressDAO = addressDAO;
	}

	public void setServiceResponseDAO(ServiceResponseDAOImpl serviceResponseDAO) {
		this.serviceResponseDAO = serviceResponseDAO;
	}

	public long submitService(Service service) {
		return serviceDAO.addService(service);
	}

	public long submitServiceResponse(ServiceResponse serviceResponse) {
		return serviceResponseDAO.addResponse(serviceResponse);
	}

	public List<Service> getServiceById(Service service) {
		return serviceDAO.findServiceById(service.getServiceId());
	}

	public List<Service> getAllServices(Service service) {
		return serviceDAO.getAllServices(service);
	}

	public List<Service> getServiceByProfession(Service service) {
		return serviceDAO.findServiceByProfession(service.getProfession());
	}

	public List<Service> getServiceByRequestedUserId(Service service) {
		return serviceDAO.findServiceByRequestedUserId(service.getReqUserId());
	}

	public List<Service> getServiceByStatus(Service service) {
		return serviceDAO.findServiceByStatus(service.getStatus());
	}

	public List<ServiceResponse> getResponseByServiceId(ServiceResponse serviceResponse) {
		return serviceResponseDAO.findResponseByServiceId(serviceResponse.getJobId());
	}

	public List<ServiceResponse> getAllServiceResponses(ServiceResponse serviceResponse) {
		return serviceResponseDAO.getAllResponses(serviceResponse);
	}

	public List<Service> getServiceRequestByAddress(Address address) {
		List<Service> serviceList = new ArrayList<Service>();
		List<User> userList = addressDAO.getUserByAddress(address);
		for (User user : userList) {
			Service service = new Service();
			service.setReqUserId(user.getUserId());
			serviceList.addAll(serviceDAO.findServiceByRequestedUserId(service.getReqUserId()));
		}

		return serviceList;
	}

	public List<ServiceResponse> getServiceResponseByRequestedUserId(Address address) {
		List<ServiceResponse> returnServiceResponseList = new ArrayList<ServiceResponse>();
		List<User> userList = addressDAO.getUserByAddress(address);
		for (User user : userList) {
			Service service = new Service();
			service.setReqUserId(user.getUserId());

			List<Service> serviceList = serviceDAO.findServiceByRequestedUserId(service.getReqUserId());

			for (Service dbService : serviceList) {
				List<ServiceResponse> serviceResponseList = serviceResponseDAO.findResponseByServiceId(dbService.getServiceId());
				returnServiceResponseList.addAll(serviceResponseList);
			}

		}

		return returnServiceResponseList;
	}

}
