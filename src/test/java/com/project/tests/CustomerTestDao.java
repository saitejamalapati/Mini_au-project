package com.project.tests;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.project.dao.CustomerDao;
import com.project.dao.CustomerDaoImplementation;
import com.project.sources.Customer;
import com.project.sources.RegisteredCustomers;

public class CustomerTestDao {
	
	static ApplicationContext context;
	static DataSource dataSource ;
	private static final Logger logger = Logger.getLogger(CustomerTestDao.class);

	static CustomerDao customerDao;
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		customerDao = new CustomerDaoImplementation();
		customerDao.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	
	@Test
	public void testAddNewCustomer()
	{
		Customer customer = new Customer(0,"shreya","9591312731","nanakaramguda");
		customerDao.addCustomer(customer);
		Customer customer1 = new Customer(0,"davis","9591313131","xyzbn");
		customerDao.addCustomer(customer1);
	}
	
	
	@Test
	public void testAddCustomerNameNull()
	{
		Customer customer = new Customer(0,null,"9591312731","nanakaramguda");
		customerDao.addCustomer(customer);
	}
	
	@Test
	public void testAddCustomerContactNull()
	{
		Customer customer = new Customer(0,"eeshan",null,"darjeeling");
		customerDao.addCustomer(customer);
	}
	
	@Test
	public void testGetCustomerid()
	{
		int id = customerDao.sendCustomerId();
		logger.info("the id given is " + id);
		
	}
	
	@Test
	public void testDeleteCustomer()
	{
		customerDao.deleteCustomer(15);
		logger.info("deleted the record successfully");
		
	}
	
	@Test
	public void testUpdateCustomer()
	{
		Customer cust = new Customer();
		cust.setCustomerId(1);
		cust.setContact("98989898989");
		cust.setAddress("dfgh");
		customerDao.updateCustomer(cust);
	}
	
	@Test
	public void testIsValidUser() {
		
		RegisteredCustomers rc = new RegisteredCustomers();
		rc.setUsername("shreya123");
		rc.setPassword("SS11");
		
		Customer cust = customerDao.isValidUser(rc);
		logger.info(cust.getCustomerId()+" "+cust.getName()+" "+cust.getAddress()+" "+cust.getContact());
	}
	

}
