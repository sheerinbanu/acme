package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Ecommerce.acme.repository.ProductRepository;
import com.Ecommerce.acme.service.CategoryService;
import com.Ecommerce.acme.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private CategoryService cs;
	
	@Autowired
	private ProductRepository pr;
	
	
	@GetMapping({"/products"})
	public String HomePage(Model model) {
		model.addAttribute("products", ps.getAllProduct());
		return "products";
		
	}
	
}
