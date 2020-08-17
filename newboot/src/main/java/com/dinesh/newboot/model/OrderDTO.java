package com.dinesh.newboot.model;

public class OrderDTO {
	private String item;
	private String quantity;
	private String rate;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "OrderDTO [item=" + item + ", quantity=" + quantity + ", rate=" + rate + "]";
	}
	
	

}
