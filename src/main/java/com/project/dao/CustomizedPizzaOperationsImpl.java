package com.project.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomizedPizzaOperationsImpl implements CustomizedPizzaOperations{

	public static Integer counter = 1;
	private JdbcTemplate jdbcTemplate;
	static final Logger logger = Logger.getLogger(com.project.dao.StaffImpl.class);

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
		
	}
	
	public String addPizzaItems(List<String> itemList) {
	
		int rowsAffected=0;
		int rowAffected=0;
		for(String cp: itemList) {
			
			String sql = "insert into pizzeria.customized_pizza values (?,?)";
			rowAffected= jdbcTemplate.update(sql,counter.toString(),cp);
			rowsAffected=rowsAffected+rowAffected;
		}
			
			if(rowsAffected == 0) {
				logger.error("unsuccessful insertion of an item in cp");
				return null;
			}
		
			else {
				logger.info("inserted item in cp successfully");
				return sendCpId();
			}
		
		
	}

	public String sendCpId() {
		
		String cpId = counter.toString();
		counter++;
		return cpId;
	}

}
