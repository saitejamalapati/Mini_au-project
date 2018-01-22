package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.RegisteredCustomerDao;
import com.project.sources.RegisteredCustomers;

@RestController
public class RegisteredCustomerController {
	@Autowired
	RegisteredCustomerDao registeredCustomerDao;
	
	@PostMapping(value = "/PizzaMiniProject/addregistercustomer")
	public void addTheRegisteredCustomer(@RequestBody RegisteredCustomers rc) {
		registeredCustomerDao.addRegisteredCustomer(rc);
	}
}
