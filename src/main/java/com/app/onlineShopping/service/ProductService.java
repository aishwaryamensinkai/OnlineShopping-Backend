package com.app.onlineShopping.service;

import com.app.onlineShopping.model.Product;
import com.app.onlineShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public Product saveProduct(Product productObj) {
		return repo.save(productObj);
	}

	public List<Product> ferchAllProducts() {
		return repo.findAll();
	}

	public Product fetchProductById(int tempId) {
		return repo.findById(tempId);
	}
}
