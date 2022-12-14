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

		for(Order o : this.getAllOrder()) {

			if( o.getUser().getId_user() == currentUserId) {

				orderList.add(o);

			}
		}

		model.addAttribute("orders", orderList);

		return "order";
	}

	public void getDetailSelectionById(int Id_order, Model model) {	

		ArrayList<Selection> detailsList = new ArrayList<Selection>();

		for(Selection s : ss.getAllSelection()) {
				
				if(s.getCart() != null && (s.getCart().getId_cart() == Id_order) ) {

					detailsList.add(s);
				}			
		}

		model.addAttribute("details", detailsList);
	}

}