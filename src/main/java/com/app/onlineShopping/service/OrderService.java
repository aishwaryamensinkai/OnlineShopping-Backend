package com.app.onlineShopping.service;

import com.app.onlineShopping.model.Order;
import com.app.onlineShopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	public Order saveOrder(Order order) {
		return repo.save(order);
	}

	public Order fetchOrderByUserId(int id) {
		return repo.findById(id);
	}
	
	public List<Order> ferchAllOrder() {
		return repo.findAll();
	}

	public Order update(Order order) {
		return repo.save(order);
	}

}
