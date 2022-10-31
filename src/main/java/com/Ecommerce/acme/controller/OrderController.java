package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.Ecommerce.acme.model.Order;
import com.Ecommerce.acme.service.OrderService;


@Controller
public class OrderController {

	@Autowired
	private OrderService os;
	

	@GetMapping({"/order_history"})
	public String getAllOrders(Model model, Authentication authentication) {
		return os.getAllOrdersByUser(authentication, model);
	}
	

	@GetMapping("/order_history/{id}")
	public String getSelectionByOrder(Model model, @ModelAttribute("selection")Order order, @PathVariable(name = "id") int Id_order){
		os.getDetailSelectionById(Id_order, model);
		return "orderDetails";
	}
	
}
