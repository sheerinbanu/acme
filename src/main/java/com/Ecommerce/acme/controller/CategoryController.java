package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService cs;

}