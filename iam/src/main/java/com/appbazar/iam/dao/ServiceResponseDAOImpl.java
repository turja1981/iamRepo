package com.appbazar.iam.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.appbazar.iam.entity.ServiceResponse;

@SuppressWarnings("unchecked")
public class ServiceResponseDAOImpl {

	@Autowired
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public long addResponse(ServiceResponse serviceResponse) {
		
		serviceResponse.setCreatedBy(String.valueOf(serviceResponse.getResponseUserId()));
		serviceResponse.setUpdatedBy(String.valueOf(serviceResponse.getResponseUserId()));
		serviceResponse.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		serviceResponse.setUpdatedOn(new Timestamp(new java.util.Date().getTime()));
		
		template.save(serviceResponse);
		return serviceResponse.getResponseId();
	}

	public List<ServiceResponse> getAllResponses(ServiceResponse serviceResponse) {
		List<ServiceResponse> responseList = (List<ServiceResponse>) template.find("from ServiceResponse");

		return responseList;
	}

	public List<ServiceResponse> findResponseById(int responseId) {
		List<ServiceResponse> responseList = (List<ServiceResponse>) template.find("from ServiceResponse where responseId = ?", responseId);

		return responseList;
	}

	public List<ServiceResponse> findResponseByStatus(String status) {
		List<ServiceResponse> responseList = (List<ServiceResponse>) template.find("from ServiceResponse where responseStatus =  ?",
				status);

		return responseList;
	}

	public List<ServiceResponse> findResponseByResponseUserId(int respUserId) {
		List<ServiceResponse> responseList = (List<ServiceResponse>) template.find("from ServiceResponse where responseStatus =  ?",
				respUserId);

		return responseList;
	}
	
	public List<ServiceResponse> findResponseByServiceId(int serviceId) {
		List<ServiceResponse> responseList = (List<ServiceResponse>) template.find("from ServiceResponse where jobId =  ?",
				serviceId);

		return responseList;
	}
}
