package com.Ecommerce.acme.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.Ecommerce.acme.model.Order;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository or;
	
	@Autowired
	private SelectionService ss;
	
	
	@Autowired
	private UserService us;
	
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
	
	public String getAllOrdersByUser(Authentication authentication, Model model) {
		
		int currentUserId = us.findByUsername(authentication.getName()).getId_user();
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Selection> detailsList = new ArrayList<Selection>();

		for(Order o : this.getAllOrder()) {

			if( o.getUser().getId_user() == currentUserId) {

				orderList.add(o);

				for(Selection s : ss.getAllSelection()) {

					if( (s.getCart().getId_cart() == o.getCart().getId_cart() ) ) {

						detailsList.add(s);
					}	
				}
			}
		}

		model.addAttribute("orders", orderList);
		model.addAttribute("details", detailsList);
		
		return "order";
	}
		
}