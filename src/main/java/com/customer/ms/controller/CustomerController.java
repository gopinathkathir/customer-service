package com.customer.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDAO custmerDAO;
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "Greetings from Spring Boot";
	}
	
	@RequestMapping(value="/customers",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Customer> getCustomers(){
		return custmerDAO.getAllCustomers();
	}
	
	@RequestMapping(value="/customer/{cusId}",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomer(@PathVariable("cusId") String cusId){
		return custmerDAO.getCustomer(cusId);
	}
	
	@RequestMapping(value="/customer",method=RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE})
	public Customer addCustomer(@RequestBody Customer customer){
		return custmerDAO.addCustomer(customer);
	}
}