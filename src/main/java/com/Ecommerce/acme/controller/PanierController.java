package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.PanierService;

@Controller
public class PanierController {
	@Autowired
	private PanierService ps;
}
