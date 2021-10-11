package com.app.onlineShopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.onlineShopping.model.Address;
import com.app.onlineShopping.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repo;
	
	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address fetchAddressByAddressId(int id) {
		return repo.findById(id);
	}
	
	public List<Address> ferchAllAddress() {
		return repo.findAll();
	}
}
