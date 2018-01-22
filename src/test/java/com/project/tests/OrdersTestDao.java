package com.project.tests;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.project.dao.OrdersDao;
import com.project.dao.OrdersDaoImplementation;
import com.project.sources.Orders;

public class OrdersTestDao {
	
	static ApplicationContext context;
	static DataSource dataSource ;
	private static final Logger logger = Logger.getLogger(OrdersTestDao.class);

	static OrdersDao ordersDao;
	
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		ordersDao = new OrdersDaoImplementation();
		ordersDao.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	
	@Test
	public void testAddOrders()
	{
		Orders order = new Orders(0,1," ",567.90,"indira nagar");
		ordersDao.addOrders(order);
		Orders order1 = new Orders(0,2," ",967.56,"nanakramguda");
		ordersDao.addOrders(order1);
		Orders order2 = new Orders(0,2," ",967.56," ");
		ordersDao.addOrders(order2);
	}
	
	@Test
	public void testGetOrderid()
	{
		int id = ordersDao.sendOrderId();
		logger.info("the order id given is: " + id);
		
	}
	
	@Test
	public void testGetAllOrders()
	{
		List<Orders> orderlist= ordersDao.getAllOrders();
		for(Orders orders : orderlist) {
			
			logger.info(orders.getOrderId()+ "  " + orders.getCustomerId() + "  "+ orders.getStatus() + "  "+ orders.getTotalPrice());
		}		
		
	}
}
