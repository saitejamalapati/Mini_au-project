package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.CartDao;
import com.project.sources.Cart;
@RestController
public class CartController {
	@Autowired
	CartDao cartDao;
	
	@PostMapping(value = "/PizzaMiniProject/addtocart")
	public void addToTheCart(@RequestBody Cart cart) {
		cartDao.addToCart(cart);
	}
	
	@DeleteMapping(value="/PizzaMiniProject/deletefromcart/{cartId}")
	public void deleteFromTheCart(@PathVariable int cartId) {
		cartDao.deleteFromCart(cartId);
	}
	@DeleteMapping(value="/PizzaMiniProject/deletefromcartbyid/{customerId}/{itemId}")
	public void deleteItemFromTheCart(@PathVariable int customerId,@PathVariable String itemId) {
		cartDao.deleteItemFromCart(customerId,itemId);
	}
}
