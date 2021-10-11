package com.app.onlineShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.onlineShopping.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	public Order findById(int id);
	public Order deleteById(int id);
}
