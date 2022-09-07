package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.OrderHistoryService;

@Controller
public class OrderHistoryController {
	
	@Autowired
	private OrderHistoryService ohs;
}
