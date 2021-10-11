package com.app.onlineShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.onlineShopping.model.Product;

public interface ProductRepository extends JpaRepository< Product, Integer>{
	public Product findById(int id);
}
