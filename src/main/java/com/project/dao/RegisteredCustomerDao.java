package com.project.dao;

import javax.sql.DataSource;

import com.project.sources.RegisteredCustomers;

public interface RegisteredCustomerDao {
	
	public void addRegisteredCustomer(RegisteredCustomers rc);
	
	public void setDataSource(DataSource dataSource);
	
}
