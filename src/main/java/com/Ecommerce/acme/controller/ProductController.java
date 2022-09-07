package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
}
