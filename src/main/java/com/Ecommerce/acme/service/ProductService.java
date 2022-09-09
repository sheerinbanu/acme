package com.Ecommerce.acme.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.repository.ProductRepository;

import lombok.Data;

@Data
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr;
	
	public Optional<Product> getProduct(final int id){
		return pr.findById(id);
	}

	public Iterable<Product> getAllProduct() {
		return pr.findAll();
	}

	public void deleteProduct(final int id) {
		pr.deleteById(id);
	}
	
	public void insertProduct(Product Product) {
		pr.save(Product);
	}
	
	
	
	
}