package com.project.tests;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.project.dao.OrderDetailsImlp;
import com.project.dao.OrderDetailsOperation;
import com.project.sources.OrderDetails;

public class OrderDetailsTestOperations {

	
	static ApplicationContext context;
	static DataSource dataSource ;
	private static final Logger logger = Logger.getLogger(CustomerTestDao.class);

	static OrderDetailsOperation orderDetailsOperation;
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		orderDetailsOperation = new OrderDetailsImlp();
		orderDetailsOperation.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	
	@Test
	public void addOrders() {
		
		OrderDetails od = new OrderDetails(1,16,"1",null,1,"small");
		OrderDetails od1 = new OrderDetails(2,17,"2",null,2,"medium");
		OrderDetails od2 = new OrderDetails(3,18,"1",null,3,"large");
		OrderDetails od3 = new OrderDetails(4,16,null,"1",1,"small");
		OrderDetails od4 = new OrderDetails(5,17,null,"1",1,"large");
		List<OrderDetails> odList = new ArrayList<>();
		odList.add(od);
		odList.add(od1);
		odList.add(od2);
		odList.add(od3);
		odList.add(od4);
		orderDetailsOperation.addOrders(odList);
	}
	
	@Test
	public void displayAllOrderDetails() {
		
		List<OrderDetails> odlist = orderDetailsOperation.displayAllOrderDetails();
		for(OrderDetails od : odlist) {
			
			logger.info(od.getOdId() + " " + od.getOrderId()+" " +od.getCpId() + " "+ od.getItemId() +" "+od.getQuantity()+" "+ od.getSize());
		}
		
	}

	@Test
	public void displayOrderDetailsById() {
		
		 
		List<OrderDetails> odlist = orderDetailsOperation.displayOrderDetailsById(7);
		for(OrderDetails od : odlist) {
			
			logger.info(od.getOdId() + " " + od.getOrderId()+" " +od.getCpId() + " "+ od.getItemId() +" "+od.getQuantity()+" "+ od.getSize());
		}
	}
	
	
	
}
