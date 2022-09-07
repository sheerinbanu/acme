package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.OrderHistory;
import com.Ecommerce.acme.repository.OrderHistoryRepository;

import lombok.Data;

@Data
@Service
public class OrderHistoryService {
	
	@Autowired
	private OrderHistoryRepository ohr;
	
	public Optional<OrderHistory> getOrderHistory(final int id){
		return ohr.findById(id);
	}

	public Iterable<OrderHistory> getAllOrderHistory() {
		return ohr.findAll();
	}

	public void deleteOrderHistory(final int id) {
		ohr.deleteById(id);
	}
	
	public void insertOrderHistory(OrderHistory OrderHistory) {
		ohr.save(OrderHistory);
	}
}