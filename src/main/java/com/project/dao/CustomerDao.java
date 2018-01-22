package com.project.dao;

import javax.sql.DataSource;

import com.project.sources.Customer;
import com.project.sources.RegisteredCustomers;

public interface CustomerDao {
	public int addCustomer(Customer cust);
	public void deleteCustomer(int customerId);
	public void updateCustomer(Customer cust);
	public Customer isValidUser(RegisteredCustomers rc);
	public int sendCustomerId();
	public void setDataSource(DataSource dataSource);
}
