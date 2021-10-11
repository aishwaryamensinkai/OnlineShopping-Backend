package com.app.onlineShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.onlineShopping.model.User;

public interface RegistrartionRepository extends JpaRepository<User,Integer>{

	public User findByEmailId(String email);
	public User findByEmailIdAndPassword(String email,String password);
	public User findById(int id);
}
