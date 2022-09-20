package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.acme.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
