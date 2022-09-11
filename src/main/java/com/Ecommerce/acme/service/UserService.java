package com.Ecommerce.acme.service;

import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.User;

@Service
public interface UserService {
    void save(User user);

    void saveAsAdmin(User user);

    User findByUsername(String username);    
    
    User findByType(String name);  
   
}