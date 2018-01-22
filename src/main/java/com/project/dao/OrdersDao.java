package com.project.dao;

import java.util.List;

import javax.sql.DataSource;

import com.project.sources.Orders;

public interface OrdersDao {
	public int addOrders(Orders o);
	public List<Orders> getAllOrders();
	public int sendOrderId();
	
	
	public void setDataSource(DataSource dataSource);
}