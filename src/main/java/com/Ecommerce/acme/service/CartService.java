package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Cart;
import com.Ecommerce.acme.repository.CartRepository;

import lombok.Data;

@Data
@Service
public class CartService {
	
	@Autowired
	private CartRepository cr;
	
	public Optional<Cart> getCart(final int id){
		return cr.findById(id);
	}

	public Iterable<Cart> getAllCart() {
		return cr.findAll();
	}

	public void deleteCart(final int id) {
		cr.deleteById(id);
	}
	
	public void insertCart(Cart Cart) {
		cr.save(Cart);
	}
}
