package com.dinesh.newboot.model;

import java.util.List;
import java.util.Map;

public class OrderListDTO {
	private int id;
	private String name;
	private boolean hasPaid;
	private float grandTotal;
	private List<Map<String, Object>> orderList;

	public OrderListDTO(int id, String name, boolean hasPaid, float grandTotal, List<Map<String, Object>> orderList) {
		this.id = id;
		this.name = name;
		this.hasPaid = hasPaid;
		this.grandTotal = grandTotal;
		this.orderList = orderList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHasPaid() {
		return hasPaid;
	}

	public void setHasPaid(boolean hasPaid) {
		this.hasPaid = hasPaid;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<Map<String, Object>> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Map<String, Object>> orderList) {
		this.orderList = orderList;
	}

}
