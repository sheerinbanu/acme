package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Ecommerce.acme.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cs;
	@GetMapping
	public String Cart(Model model) {
		model.addAttribute("cart",cs.getAllCart());
		return "cart";
	}
	
}
