package com.app.onlineShopping.repository;

import com.app.onlineShopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository< Product, Integer>{
	public Product findById(int id);
}
