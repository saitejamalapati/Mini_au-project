package com.project.dao;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.project.sources.Staff;


public class StaffImpl implements StaffOperations{

	private JdbcTemplate jdbcTemplate;
	static final Logger logger = Logger.getLogger(com.project.dao.StaffImpl.class);

	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
		
	}

	public void addStaff(Staff staff) {
		String sql = "insert into pizzeria.staff (staff_name,username,password,category,contact) values (?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sql, staff.getStaffName(), staff.getUsername(),staff.getPassword(),
				staff.getCategory(),staff.getContact());
		
		if(rowsAffected == 0) {
			logger.error("unsuccessful insertion of staff");
		}
		
		else logger.info("inserted staff successfully");
	}

	public void deleteStaff(int staffId) {
		String sql = "delete from pizzeria.staff where staff_id = ?";
		int rowsAffected =  jdbcTemplate.update(sql,staffId);
		
		if(rowsAffected == 0) {
			logger.error("unsuccessful deletion of staff");
		}
		
		else logger.info("deleted record from staff successfully");
		
	}

	public void changeStatus(int orderId) {
		String sql = "update pizzeria.orders set status = 'delivered' where order_id = ?";
		
		int rowsAffected =  jdbcTemplate.update(sql,orderId);
		if(rowsAffected == 0) {
			logger.error("unsuccessful updation of order status");
		}
		
		else logger.info("updated order status successfully");
	}


}
