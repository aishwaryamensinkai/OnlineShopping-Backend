package com.app.onlineShopping.repository;

import com.app.onlineShopping.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository< Address, Integer> {
	public Address findById(int id);
	public Address deleteById(int id);
}
