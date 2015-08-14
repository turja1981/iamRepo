package com.appbazar.iam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CustomerController {

	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public Customer restJsonResponse (@PathVariable String name)
	{
		Customer cust  = new Customer();
		cust.setFirstName("Turja");
		cust.setLastName("Banerjee");
		
		return cust ;
	}
}
