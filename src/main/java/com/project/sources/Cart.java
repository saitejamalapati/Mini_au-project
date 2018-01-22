package com.project.sources;

public class Cart {
	
	private int customeId;
	private int cartItemId;
	private String cpId;
	private String itemId;
	private String size;
	
	public Cart() {}

	public Cart(int customeId, int cartItemId, String cpId, String itemId,String size) {
		super();
		this.customeId = customeId;
		this.cartItemId = cartItemId;
		this.cpId = cpId;
		this.itemId = itemId;
		this.size = size;
	}

	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCustomeId() {
		return customeId;
	}

	public void setCustomeId(int customeId) {
		this.customeId = customeId;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
	
	

}
