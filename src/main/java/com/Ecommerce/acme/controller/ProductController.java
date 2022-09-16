package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Ecommerce.acme.repository.ProductRepository;
import com.Ecommerce.acme.service.CategoryService;
import com.Ecommerce.acme.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	
	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("products", ps.getAllProduct());
		return "home";
		
		//SELECT category.name FROM CATEGORY INNERJOIN  PRODUCT ON product.id_category=id.category.name;
	}
	
	
	
}
