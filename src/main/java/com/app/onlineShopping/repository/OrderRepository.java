package com.app.onlineShopping.repository;

import com.app.onlineShopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	public Order findById(int id);
	public Order deleteById(int id);
}
