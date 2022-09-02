package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.ProduitService;

@Controller
public class ProduitController {
	@Autowired
	private ProduitService ps;
}
