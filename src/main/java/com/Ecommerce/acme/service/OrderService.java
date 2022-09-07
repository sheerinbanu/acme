package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Order;
import com.Ecommerce.acme.repository.OrderRepository;

import lombok.Data;

@Data
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository or;
	
	public Optional<Order> getOrder(final int id){
		return or.findById(id);
	}

	public Iterable<Order> getAllOrder() {
		return or.findAll();
	}

	public void deleteOrder(final int id) {
		or.deleteById(id);
	}
	
	public void insertOrder(Order Order) {
		or.save(Order);
	}
}