package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.sources.Customer;
import com.project.sources.RegisteredCustomers;

public class CustomerDaoImplementation implements CustomerDao {
	private JdbcTemplate jdbcTemplate;
	static final Logger logger = Logger.getLogger(com.project.dao.CustomerDaoImplementation.class);
	static List<Customer> customerList=new ArrayList<>();
	
	public String getHashedPassword(String psw) {
		
		String cryptedPassword = new BCryptPasswordEncoder().encode("password");
		System.out.println(cryptedPassword);
		return cryptedPassword;
	}
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
		
	}
	
	public CustomerDaoImplementation() {
		BasicConfigurator.configure();
	}
	
	/* (non-Javadoc)
	 * @see com.project.dao.CustomerDao#addCustomer(com.project.sources.Customer)
	 */
	public int addCustomer(Customer cust) {
		String query="Insert into pizzeria.customer(name,contact,address)values(?,?,?) ";
		jdbcTemplate.update(query,cust.getName(),cust.getContact(),cust.getAddress());
		logger.info("A new customer is added");
		return sendCustomerId();
			
	}
	
	/* (non-Javadoc)
	 * @see com.project.dao.CustomerDao#sendCustomerId()
	 */
	public int sendCustomerId() {
		String query1="Select max(customer_id) from pizzeria.customer ";
		return jdbcTemplate.queryForObject(query1,Integer.class);
		
	}
	
	public void deleteCustomer(int customerId) {
		String query="Delete from pizzeria.customer where customer_id=?";
		jdbcTemplate.update(query,customerId);
		logger.info("Customer is deleted with customer id:"+customerId);
		
	}
	public void updateCustomer(Customer cust) {
		
		String query="Update pizzeria.customer set contact=?,address=? where customer_id=?";
		jdbcTemplate.update(query,cust.getContact(),cust.getAddress(),cust.getCustomerId());
		logger.info("Customer is updated ");
	}
	/* (non-Javadoc)
	 * @see com.project.dao.CustomerDao#isValidUser(com.project.sources.Registered_Customers)
	 */
	public Customer isValidUser(RegisteredCustomers rc) {
		String uname = rc.getUsername();
		String psw = rc.getPassword();
		String cryptedPsw = getHashedPassword(psw);
		logger.info(uname+psw);
		Integer rowsAffected;
		Integer customerId;
		
		/*String sqlquery = "Select password from pizzeria.registered_customers where username = ?";
		String curPsw = (String) jdbcTemplate.queryForObject(sqlquery, new Object[] { uname }, String.class);
		if(curPsw.matches(cryptedPsw)) {
			
		}*/
		
		String query1="Select count(*) from pizzeria.registered_customers where username=? and password=?";
		rowsAffected = jdbcTemplate.queryForObject(query1,new Object[] {uname,psw},Integer.class);
		logger.info("rowsAffected" +rowsAffected);
		
		if(rowsAffected!=0) {
			
			String query="Select customer_id from pizzeria.registered_customers where username=?";
			 customerId = jdbcTemplate.queryForObject(query,new Object[] {uname},Integer.class);
			logger.info("customId = "+customerId);
			
			String query3 = "select * from pizzeria.customer where customer_id = ?";
			Customer cust = jdbcTemplate.queryForObject(query3,new Object[] { customerId }, new BeanPropertyRowMapper<Customer>(Customer.class));
			logger.info("customer" +cust.getName());
			return cust;
			
		}
		else {
			
			return null;
		}
		
	}
	
}
