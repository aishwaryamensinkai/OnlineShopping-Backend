package com.app.onlineShopping.service;

import com.app.onlineShopping.model.User;
import com.app.onlineShopping.repository.RegistrartionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	@Autowired
	private RegistrartionRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}

	public User fetchUserByUserId(int id) {
		return repo.findById(id);
	}
}
