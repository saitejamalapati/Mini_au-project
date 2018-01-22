package com.project.sources;

public class OrderDetails {
	private int odId;
	private int orderId;
	private String itemId;
	private String cpId;
	private int quantity;
	private String size;
	
	

	public OrderDetails() {}

	public OrderDetails(int odId, int orderId, String itemId, String cpId, int quantity,String size) {
		super();
		this.odId = odId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.cpId = cpId;
		this.quantity = quantity;
		this.size = size;
	}
	


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
