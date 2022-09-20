package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Ecommerce.acme.model.Order;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.OrderService;


@Controller
public class OrderController {

	@Autowired
	private OrderService os;

	@GetMapping({"/order_history"})
	public String profil(Model model, Order order, Authentication authentication) {
		return os.getAllOrdersByUser(authentication, model);
	}
		
}
