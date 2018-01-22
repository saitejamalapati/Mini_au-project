package com.project.tests;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.project.dao.RegisteredCustomerDao;
import com.project.dao.RegisteredCustomerDaoImplementation;
import com.project.sources.RegisteredCustomers;

public class RegisteredCustomerTestdao {
	static ApplicationContext context;
	static DataSource dataSource ;
	

	static RegisteredCustomerDao registerCustomerDao;
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		registerCustomerDao = new RegisteredCustomerDaoImplementation();
		registerCustomerDao.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	
	@Test
	public void testAddRegisteredCustomer() {
		RegisteredCustomers rc = new RegisteredCustomers(1,"22/09/1996", "shreya123","SS11" );
		registerCustomerDao.addRegisteredCustomer(rc);
		RegisteredCustomers rc1 = new RegisteredCustomers(2,"23/09/1996", "eeshan221","ES22" );
		registerCustomerDao.addRegisteredCustomer(rc1);
	}
}
