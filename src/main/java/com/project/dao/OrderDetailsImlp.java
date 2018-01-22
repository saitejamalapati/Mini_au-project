package com.project.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.project.sources.OrderDetails;

public class OrderDetailsImlp implements OrderDetailsOperation {
	
	private JdbcTemplate jdbcTemplate;
	static final Logger logger = Logger.getLogger(com.project.dao.StaffImpl.class);

	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
		
	}
	public void addOrders(List<OrderDetails> odList) {
		
		for(OrderDetails od : odList) {
			
			if(od.getCpId() == null) {
				String sql = "insert into pizzeria.order_details (order_id,item_id,quantity,size) values (?,?,?,?)";
				int rowsAffected = jdbcTemplate.update(sql, od.getOrderId(), od.getItemId(),od.getQuantity(),od.getSize());
			
				if(rowsAffected == 0) {
					logger.error("unsuccessful insertion of order details");
				}
			
				else logger.info("inserted order details successfully");
			}
		
			else {
			
				String sql2 =  "insert into pizzeria.order_details (order_id,cp_id,quantity,size) values (?,?,?,?)";
			
				int rowsAffected2 = jdbcTemplate.update(sql2, od.getOrderId(), od.getCpId(),od.getQuantity(),od.getSize());
			
				if(rowsAffected2 == 0) {
					logger.error("unsuccessful insertion of order details");
				}
			
				else logger.info("inserted order details successfully");
			}
			
		}
		
	}

	public List<OrderDetails> displayAllOrderDetails() {
		
		List<OrderDetails> odDetails;
		String sql = "select * from pizzeria.order_details";
		odDetails = jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderDetails>(OrderDetails.class));
		logger.info("Order details are displayed");
		return odDetails;
		
	}

	public List<OrderDetails> displayOrderDetailsById(int orderId) {
		
		List<OrderDetails> odDetails;
		String sql = "select * from pizzeria.order_details where order_id = ?";
		odDetails = jdbcTemplate.query(sql,new Object[] { orderId }, new BeanPropertyRowMapper<OrderDetails>(OrderDetails.class));
		logger.info("Order of order id "+orderId+"details are displayed ");
		return odDetails;
	}

}
