package com.project.sources;

public class RegisteredCustomers {
	private int customerId;
	private String dob;
	private String username;
	private String password;
	
	public RegisteredCustomers() {}

	public RegisteredCustomers(int customerId, String dOB, String username, String password) {
		super();
		this.customerId = customerId;
		this.dob = dOB;
		this.username = username;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
