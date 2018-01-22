package com.project.tests;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.project.dao.StaffImpl;
import com.project.dao.StaffOperations;
import com.project.sources.Staff;

public class StaffTestDao {

	
	static ApplicationContext context;
	static DataSource dataSource ;
	private static final Logger logger = Logger.getLogger(StaffTestDao.class);

	static StaffOperations staffOperations;
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		staffOperations = new StaffImpl();
		staffOperations.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	
	@Test
	public void testAddNewStaff()
	{
		Staff staff = new Staff(0,"John parker","JP11","11jp","manager","9436789077");
		staffOperations.addStaff(staff);
		Staff staff1 = new Staff(0,"Peter parker","PP11","11pp","manager","9436821377");
		staffOperations.addStaff(staff1);
	}
	
	

	@Test
	public void testdeleteStaff()
	{
		staffOperations.deleteStaff(1);
		logger.info("deleted the record successfully");
	}

	@Test
	public void testChangeStatus()
	{
		staffOperations.changeStatus(6);
		staffOperations.changeStatus(1);
	}

}
