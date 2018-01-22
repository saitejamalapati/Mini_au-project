package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.MenuOperations;
import com.project.sources.Menu;



@RestController
public class MenuController {
	
	@Autowired
	MenuOperations menuOperations;
	
	@GetMapping(value = "/PizzaMiniProject/vegmenu")
	public List<Menu> getTheVegPizza() {
		return menuOperations.getVegPizza();
	}
	
	@GetMapping(value="/PizzaMiniProject/menu")
	public List<Menu> getTheMenu(){
		
		return menuOperations.getMenu();
	}

	@GetMapping(value = "/PizzaMiniProject/nonvegmenu")
	public List<Menu> getTheNonVegPizza() {
		return menuOperations.getNonVegPizza();
	}
	
	@GetMapping(value = "/PizzaMiniProject/combomenu")
	public List<Menu> getTheCombos() {
		return menuOperations.getCombos();
	}
	
	@GetMapping(value = "/PizzaMiniProject/crustmenu")
	public List<Menu> getTheCrusts() {
		return menuOperations.getCrusts();
	}
	
	@GetMapping(value = "/PizzaMiniProject/vegtoppingmenu")
	public List<Menu> getTheVegToppings() {
		return menuOperations.getVegToppings();
	}
	
	@GetMapping(value = "/PizzaMiniProject/nonvegtoppingmenu")
	public List<Menu> getTheNonVegToppings() {
		return menuOperations.getNonVegToppings();
	}

}
