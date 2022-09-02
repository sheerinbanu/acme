package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Admin;
import com.Ecommerce.acme.repository.AdminRepository;

import lombok.Data;

@Data
@Service
public class AdminService {
	
	@Autowired
	private AdminRepository ar;
	
	public Optional<Admin> getAdmin(final int id){
		return ar.findById(id);
	}

	public Iterable<Admin> getAllAdmin() {
		return ar.findAll();
	}

	public void deleteAdmin(final int id) {
		ar.deleteById(id);
	}
	
	public void insertAdmin(Admin Admin) {
		ar.save(Admin);
	}
}
