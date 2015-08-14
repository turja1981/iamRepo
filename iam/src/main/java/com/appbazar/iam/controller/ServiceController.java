package com.appbazar.iam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appbazar.iam.service.ProfessionalService;

@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ProfessionalService professionalService;

	public void setProfessionalService(ProfessionalService professionalService) {
		this.professionalService = professionalService;
	}
	
	
	

}
