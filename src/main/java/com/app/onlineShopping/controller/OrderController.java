package com.app.onlineShopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.onlineShopping.model.Order;
import com.app.onlineShopping.repository.OrderRepository;
import com.app.onlineShopping.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderRepository repo;
	
	@PostMapping("/saveOrder")
	@CrossOrigin(origins = "http://localhost:4200")
	public Order saveOrderIndb(@RequestBody Order order) throws Exception,Throwable {
		Order OrderObj = null;
		OrderObj = service.saveOrder(order);
		return OrderObj;
	}
	
	@GetMapping("/getOrder/{userId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Order getOrderIndb(@PathVariable(value = "userId") int id) throws Exception,Throwable {
		return service.fetchOrderByUserId(id);
	}
	
	@GetMapping("/getAllOrders")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Order> getAllNotes()
    {
        return service.ferchAllOrder();
    }
	
	@DeleteMapping("/deleteOrder/{orderId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Order deleteOrder(@PathVariable(value = "orderId") int id)
	{
		return repo.deleteById(id);
	}
	
	@PutMapping("/updateOrder/{orderId}")
	@CrossOrigin(origins = "http://localhost:4200")
	private ResponseEntity<Object> updateOrder(@RequestBody Order order,@PathVariable(value = "orderId") int id)   
	{  
		Optional<Order> orderRepo = Optional.ofNullable(repo.findById(id));
		if(!orderRepo.isPresent())
			return ResponseEntity.notFound().build();
		order.setOrderId(id);
		repo.save(order);
		return ResponseEntity.noContent().build();
	}
}
