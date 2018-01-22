package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.CustomizedPizzaOperations;

@RestController
public class CustomizedPizzaController {
	
	@Autowired
	CustomizedPizzaOperations customizedPizzaOperations;
	
	@PostMapping(value = "/PizzaMiniProject/addcustomizepizza")
	public void addTheOrders(@RequestBody List<String> cpList) {
	
		customizedPizzaOperations.addPizzaItems(cpList);
	}
	
}
