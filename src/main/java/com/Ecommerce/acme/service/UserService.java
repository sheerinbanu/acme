package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public Optional<User> getUser(final int id){
		return ur.findById(id);
	}

	public Iterable<User> getAllUser() {
		return ur.findAll();
	}

	public void deleteUser(final int id) {
		ur.deleteById(id);
	}
	
	public void insertUser(User User) {
		ur.save(User);
	}
	
	public User login(String email, String password) {
		User user = ur.findByEmailAndPassword(email, password);
		return user;
	}	
	
}