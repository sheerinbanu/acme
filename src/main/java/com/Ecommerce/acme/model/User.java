package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name= "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	
	private String last_name;
	
	private String first_name;
	
	private String email;
	
	private String password;
	
	
	public User() {
		
	}

	public User(String email, String password) {
		
		this.email = email;
		this.password = password;
	}
	
}
