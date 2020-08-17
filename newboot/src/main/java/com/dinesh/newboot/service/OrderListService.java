package com.dinesh.newboot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.newboot.model.OrderList;

public interface OrderListService extends JpaRepository<OrderList, Long>  {
}
