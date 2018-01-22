package com.project.dao;

import java.util.List;

import javax.sql.DataSource;

import com.project.sources.OrderDetails;

public interface OrderDetailsOperation {
	
	public void addOrders(List<OrderDetails> odList);
	
	public List<OrderDetails> displayAllOrderDetails();
	
	public List<OrderDetails> displayOrderDetailsById(int orderId);
	

	public void setDataSource(DataSource dataSource);

}
