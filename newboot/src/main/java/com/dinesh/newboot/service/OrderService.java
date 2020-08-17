package com.dinesh.newboot.service;

import org.springframework.data.repository.CrudRepository;

import com.dinesh.newboot.model.Order;

public interface OrderService extends CrudRepository<Order, Integer>  {
	public Order findById(int id);
}
