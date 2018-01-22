package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.OrdersDao;
import com.project.sources.Orders;
@RestController
public class OrdersController {

@Autowired
OrdersDao ordersDao;

@GetMapping(value="/PizzaMiniProject/getallorder")
public List<Orders> getAllTheOrders() {
	return ordersDao.getAllOrders();
}

@PostMapping(value="/PizzaMiniProject/addorder")
public void addTheOrders(@RequestBody Orders o) {
	ordersDao.addOrders(o);
}

}
