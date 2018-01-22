package com.project.tests;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.project.dao.MenuOperations;
import com.project.dao.MenuOperationsImpl;
import com.project.sources.Menu;

public class MenuTestOperations {

	static ApplicationContext context;
	static DataSource dataSource ;
	private static final Logger logger = Logger.getLogger(MenuTestOperations.class);

	static MenuOperations menuOperations;
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		menuOperations = new MenuOperationsImpl();
		menuOperations.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	
	@Test
	public void testGetMenu()
	{
		List<Menu> menu = menuOperations.getMenu();
		for(Menu pizza :menu) {
			
			logger.info(pizza.getItemName()+ "  " + pizza.getCategory() + " = "+pizza.getDescription());
		}		
		
	}
	
	
	@Test
	public void testGetMenuVeg()
	{
		List<Menu> menu = menuOperations.getVegPizza();
		for(Menu pizza :menu) {
			
			logger.info(pizza.getItemName()+ "  " + pizza.getCategory() + " = "+pizza.getDescription());
		}		
		
	}
	
	@Test
	public void testGetMenuCombo()
	{
		List<Menu> menu = menuOperations.getCombos();
		for(Menu pizza :menu) {
			
			logger.info(pizza.getItemName()+ "  " + pizza.getCategory() + " = "+pizza.getDescription());
		}		
		
	}
	
	@Test
	public void testGetMenuNonveg()
	{
		List<Menu> menu = menuOperations.getNonVegPizza();
		for(Menu pizza :menu) {
			
			logger.info(pizza.getItemName()+ "  " + pizza.getCategory() + " = "+pizza.getDescription());
		}		
		
	}
	
	@Test
	public void testGeVegToppings()
	{
		List<Menu> menu = menuOperations.getVegToppings();
		for(Menu pizza :menu) {
			
			logger.info(pizza.getItemName()+ "  " + pizza.getCategory() + " = "+pizza.getDescription());
		}		
		
	}
	
	@Test
	public void testGetNonvegToppings()
	{
		List<Menu> menu = menuOperations.getNonVegToppings();
		for(Menu pizza :menu) {
			
			logger.info(pizza.getItemName()+ "  " + pizza.getCategory() + " = "+pizza.getDescription());
		}		
		
	}
	
	@Test
	public void testGetCrusts()
	{
		List<Menu> menu = menuOperations.getCrusts();
		for(Menu pizza :menu) {
			
			logger.info(pizza.getItemName()+ "  " + pizza.getCategory() + " = "+pizza.getDescription());
		}		
		
	}
	
}
