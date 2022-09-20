package com.Ecommerce.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Ecommerce.acme.model.Role;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.repository.UserRepository;

@Service
public class AuthService{
	
	 @Autowired
	    UserRepository userRepository;

	    @Autowired
	    PasswordEncoder passwordEncoder;

	    public void createNewUser(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        Role role = Role.CLIENT;
	        user.setRole(role);
	        userRepository.save(user);
	    }
	    
	    public void createNewAdmin(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        Role role = Role.ADMIN;
	        user.setRole(role);
	        userRepository.save(user);
	    }
	
}
