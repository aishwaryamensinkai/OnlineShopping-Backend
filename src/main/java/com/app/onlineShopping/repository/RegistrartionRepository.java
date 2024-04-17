package com.app.onlineShopping.repository;

import com.app.onlineShopping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrartionRepository extends JpaRepository<User,Integer>{

	public User findByEmailId(String email);
	public User findByEmailIdAndPassword(String email,String password);
	public User findById(int id);
}
