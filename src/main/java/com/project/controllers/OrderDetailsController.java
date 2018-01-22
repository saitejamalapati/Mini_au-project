package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.OrderDetailsOperation;
import com.project.sources.OrderDetails;


@RestController
public class OrderDetailsController {

	
	@Autowired
	OrderDetailsOperation orderDetails;
	
	@PostMapping(value = "/PizzaMiniProject/addorderdetails")
	public void addTheOrders(@RequestBody List<OrderDetails> odList) {
	
		orderDetails.addOrders(odList);
	}
	
	@GetMapping(value = "/PizzaMiniProject/allorderdetails")
	public List<OrderDetails> displayAllTheOrderDetails() {
		return orderDetails.displayAllOrderDetails();
	}
	
	@GetMapping(value = "/PizzaMiniProject/orderdetailsbyid/{orderId}")
	public  List<OrderDetails> displayTheOrderDetailsById(@PathVariable int orderId){
		
		return orderDetails.displayOrderDetailsById(orderId);
	}
}
