package com.customer.ms.service;

import java.util.List;

import com.customer.ms.model.CustomerM;

public interface CustomerService {

	List<CustomerM> findAll();
	CustomerM findById(String cusId);
	CustomerM addCustomer(CustomerM customerM);
	CustomerM updateCustomer(CustomerM customerM);
	void deleteCustomer(String cusId);
}
