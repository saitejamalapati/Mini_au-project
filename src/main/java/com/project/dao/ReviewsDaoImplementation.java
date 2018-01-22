package com.project.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.project.sources.Reviews;

public class ReviewsDaoImplementation implements ReviewsDao{
	private JdbcTemplate jdbcTemplate;
	static final Logger logger = Logger.getLogger(com.project.dao.ReviewsDaoImplementation.class);
	
	public ReviewsDaoImplementation() {
		BasicConfigurator.configure();
		
	}
	

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
		
	}
	
	public void addReview(Reviews r) {
	String query="Insert into pizzeria.reviews(customer_id,rating,review) values (?,?,?) ";
	
	jdbcTemplate.update(query,r.getCutomerId(),r.getRating(),r.getReview());
	logger.info("A Review is added");
}
	
	public List<Reviews> getAllReviews() {
		String query = "select * from pizzeria.reviews";
		logger.info("Review list is displayed");
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Reviews>(Reviews.class));
	}
}