package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Ecommerce.acme.service.OrderService;

@Controller
public class AdminController {
@Autowired
	private OrderService os;
@GetMapping({"/Admin"})
public String Homepage(Model model) {
	model.addAttribute("orders",os.getAllOrder());
	return "HomePageAdmin";
}
}
