package com.project.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.project.sources.Menu;

public class MenuOperationsImpl implements MenuOperations{
	
	private JdbcTemplate jdbcTemplate;
	String sql = "select * from pizzeria.menu where category = ?";
	static final Logger logger = Logger.getLogger(com.project.dao.MenuOperationsImpl.class);
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
		
	}

	public List<Menu> getMenu() {
		List<Menu> menu;
		String sql1 = "select * from pizzeria.menu";
		menu = jdbcTemplate.query(sql1, new BeanPropertyRowMapper<Menu>(Menu.class));
		logger.info("Full Menu list is returned");
		return menu;
	}

	public List<Menu> getVegPizza() {
		
		List<Menu> menuVegPizza;
		
		menuVegPizza = jdbcTemplate.query(sql,new Object[]{"veg"}, new BeanPropertyRowMapper<Menu>(Menu.class));
		logger.info("veg pizza Menu list is displayed");
		return menuVegPizza;
		    
	}

	public List<Menu> getNonVegPizza() {
		List<Menu> menuNonVegPizza;

		menuNonVegPizza = jdbcTemplate.query(sql,new Object[]{"nonveg"}, new BeanPropertyRowMapper<Menu>(Menu.class));
		logger.info("nonveg pizza Menu list is displayed");
		return menuNonVegPizza;
		    
	}

	public List<Menu> getCombos() {
		List<Menu> combos;

		combos = jdbcTemplate.query(sql,new Object[]{"combo"}, new BeanPropertyRowMapper<Menu>(Menu.class));
		logger.info("Combos list is displayed");
		return combos;
		    
	}

	public List<Menu> getCrusts() {
		List<Menu> crusts;
		
		crusts = jdbcTemplate.query(sql,new Object[]{"crust"}, new BeanPropertyRowMapper<Menu>(Menu.class));
		logger.info("crusts list is diaplayed");
		return crusts;
	}

	public List<Menu> getVegToppings() {
		List<Menu> vegToppings;

		vegToppings = jdbcTemplate.query(sql,new Object[]{"vegtoppings"}, new BeanPropertyRowMapper<Menu>(Menu.class));
		logger.info("vegtoppings list is diaplayed");
		return vegToppings;
	}

	public List<Menu> getNonVegToppings() {
		List<Menu> nonvegToppings;
	
		nonvegToppings = jdbcTemplate.query(sql,new Object[]{"nonvegtoppings"}, new BeanPropertyRowMapper<Menu>(Menu.class));
		logger.info("nonvegtoppings list is diaplayed");
		return nonvegToppings;
	}

	
}
