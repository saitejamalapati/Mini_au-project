package com.project.tests;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.project.dao.ReviewsDao;
import com.project.dao.ReviewsDaoImplementation;
import com.project.sources.Reviews;

public class ReviewTestDao {
	static ApplicationContext context;
	static DataSource dataSource ;
	private static final Logger logger = Logger.getLogger(ReviewTestDao.class);

	static ReviewsDao reviewsDao;
	@BeforeClass
	public static void setUp()
	{
		context = new FileSystemXmlApplicationContext("src\\main\\webapp\\WEB-INF\\springDispatcherServlet-servlet.xml");
		dataSource = (DataSource) context.getBean("dataSource");
		reviewsDao = new ReviewsDaoImplementation();
		reviewsDao.setDataSource(dataSource);
		BasicConfigurator.configure();
		
	}
	
	
	@Test
	public void addReview() {
		Reviews r = new Reviews(1, 1, 2.20, "good");
		Reviews r1 = new Reviews(2, 2, 4.10, "amazing experience");
		reviewsDao.addReview(r);
		reviewsDao.addReview(r1);
		
	}
	
	@Test
	public void getAllReviews(){
		List<Reviews> rl = reviewsDao.getAllReviews();
		for(Reviews a:rl) {
			logger.info(a.getReviewId()+" "+a.getCutomerId()+" "+a.getRating()+" "+a.getReview());
			}
	}
}
