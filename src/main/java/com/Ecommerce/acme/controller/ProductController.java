package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Ecommerce.acme.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	@GetMapping("/manage_product")
	public String Product(Model model) {
		model.addAttribute("product",ps.getAllProduct());
		return "product";
	}
}
