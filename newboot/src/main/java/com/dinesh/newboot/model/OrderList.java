package com.dinesh.newboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "OrderList")
@Table(name = "order_lists")
public class OrderList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orderId;
	@Column
	private String itemName;
	@Column
	private Float rate;
	@Column
	private Float quantity;

	public OrderList() {
	}

	public OrderList(Order orderId, String itemName, Float rate, Float quantity) {
		this.orderId = orderId;
		this.itemName = itemName;
		this.rate = rate;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(Float price) {
		this.rate = price;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

}
