package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	
}
