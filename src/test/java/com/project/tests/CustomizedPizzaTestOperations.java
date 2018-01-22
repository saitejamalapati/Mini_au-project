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

import com.project.dao.CustomizedPizzaOperations;
import com.project.dao.CustomizedPizzaOperationsImpl;

public class CustomizedPizzaTestOperations {
	static ApplicationContext context;
	
	static DataSource dataSource ;
	private static final Logger logger = Logger.getLogger(CustomizedPizzaTestOperations.class);

	static CustomizedPizzaOperations customizedPizzaOperations;
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		customizedPizzaOperations = new CustomizedPizzaOperationsImpl();
		customizedPizzaOperations.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	@Test
	public void testAddPizzaItems() {
		
		List<String> listItems=new ArrayList<>();
		
		
		listItems.add("2");
		listItems.add("3");
		String id = customizedPizzaOperations.addPizzaItems(listItems);
		logger.info("the customized pizza id is :" + id);
	
	}
}

