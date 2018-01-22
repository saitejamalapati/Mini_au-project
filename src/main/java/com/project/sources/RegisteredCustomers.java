package com.project.sources;

public class Registered_Customers {
	private int customerId;
	private String dob;
	private String username;
	private String password;
	
	public Registered_Customers() {}

	public Registered_Customers(int customer_id, String dOB, String username, String password) {
		super();
		this.customerId = customer_id;
		this.dob = dOB;
		this.username = username;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customer_id) {
		this.customerId = customer_id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dOB) {
		dob = dOB;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
