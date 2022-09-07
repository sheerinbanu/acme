package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Ecommerce.acme.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService os;
}
