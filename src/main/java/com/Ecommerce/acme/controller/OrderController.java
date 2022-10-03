package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Ecommerce.acme.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService os;

	@GetMapping({"/order_history"})
	public String profil(Model model, Authentication authentication) {
		return os.getAllOrdersByUser(authentication, model);
	}
		
}
