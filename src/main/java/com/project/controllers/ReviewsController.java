package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.ReviewsDao;
import com.project.sources.Reviews;
@RestController
public class ReviewsController {
	
		@Autowired
		ReviewsDao reviewsDao;
		
		@PostMapping(value="/PizzaMiniProject/addreview")
		public void addTheReview(@RequestBody Reviews r) {
			reviewsDao.addReview(r);
		}
}
