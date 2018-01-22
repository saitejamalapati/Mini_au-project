package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.CustomerDao;
import com.project.sources.Customer;
import com.project.sources.RegisteredCustomers;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;
	
	@PostMapping(value = "/PizzaMiniProject/register")
	public void createNewCustomer(@RequestBody Customer cust) {
		 customerDao.addCustomer(cust);
		
	}
		
	@DeleteMapping(value = "/PizzaMiniProject/deleteustomer/{customerId}")
	public void deleteTheCustomer(@PathVariable int customerId) {
		customerDao.deleteCustomer(customerId);
	}
	
	@PostMapping(value="/PizzaMiniProject/valid")
	public Customer validUser(@RequestBody RegisteredCustomers rc) {
		return customerDao.isValidUser(rc);
	}
	
	@PutMapping(value="/PizzaMiniProject/updatecustomer")
	public void updateTheCustomer(@RequestBody Customer cust) {
		customerDao.updateCustomer(cust);
	}
	
	
	
	

}
