package com.app.onlineShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.onlineShopping.model.Address;


public interface AddressRepository extends JpaRepository< Address, Integer> {
	public Address findById(int id);
	public Address deleteById(int id);
}
