package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cs;
}
