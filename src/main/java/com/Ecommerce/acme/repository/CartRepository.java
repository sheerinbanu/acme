package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.acme.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
