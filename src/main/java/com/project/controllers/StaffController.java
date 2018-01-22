package com.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.StaffOperations;
import com.project.sources.Staff;



@RestController
public class StaffController {

	@Autowired
	StaffOperations staffOperations;
	
	@PostMapping(value = "/PizzaMiniProject/addstaff")
	public void addTheStaff(@RequestBody Staff staff) {
	
		staffOperations.addStaff(staff);
	}
	
	@DeleteMapping(value = "/PizzaMiniProject/deletestaff/{staffId}")
	public void deleteTheStaff(@PathVariable int staffId) {
		
		staffOperations.deleteStaff(staffId);
	}
	
	@PutMapping(value = "/PizzaMiniProject/changestatus/{orderId}")
	public void changeTheStatus(@PathVariable int orderId) {

		staffOperations.changeStatus(orderId);
	}
	
}
