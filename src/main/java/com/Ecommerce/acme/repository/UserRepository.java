package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.acme.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmailAndPassword(String email, String Password);
}
