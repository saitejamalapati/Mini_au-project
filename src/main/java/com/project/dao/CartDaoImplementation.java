package com.project.dao;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.project.sources.Cart;

public class CartDaoImplementation implements CartDao{
	private JdbcTemplate jdbcTemplate;
	static final Logger logger = Logger.getLogger(com.project.dao.CustomerDaoImplementation.class);
	
	
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
		
	}
	
	public CartDaoImplementation() {
		BasicConfigurator.configure();
	}
	
	/* (non-Javadoc)
	 * @see com.project.dao.CartDao#addToCart(com.project.sources.Cart)
	 */
	public void addToCart(Cart cart) {
		
		if(cart.getCpId().equals("-1")) {
			
			String query="Insert into pizzeria.cart(customer_id,cart_item_id,cp_id,item_id,size) values (?,?,?,?,?) ";
			jdbcTemplate.update(query,cart.getCustomeId(),cart.getCartItemId(),null,cart.getItemId(),cart.getSize());
		}
		
		else {
			
			String query="Insert into pizzeria.cart(customer_id,cart_item_id,cp_id,item_id,size) values (?,?,?,?,?) ";
			jdbcTemplate.update(query,cart.getCustomeId(),cart.getCartItemId(),cart.getCpId(),null,cart.getSize());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.project.dao.CartDao#deleteFromCart(int)
	 */
	public void deleteFromCart(int customerId) {
		String query="Delete from pizzeria.cart where customer_id=?";
		jdbcTemplate.update(query,customerId);
		logger.info("Cart items of"+customerId+"are deleted");

	}
	
	/* (non-Javadoc)
	 * @see com.project.dao.CartDao#deleteItemFromCart(int, java.lang.String)
	 */
	public void deleteItemFromCart(int customerId,String itemId) {
		String query="Delete from pizzeria.cart where customer_id=? and item_id=?";
		jdbcTemplate.update(query,customerId,itemId);
		logger.info("Cart item with item_id"+itemId+" of customer with customer_id"+customerId+"are deleted");
	}

	
	
}
