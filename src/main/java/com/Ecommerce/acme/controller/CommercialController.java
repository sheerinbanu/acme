package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.CommercialService;

@Controller
public class CommercialController {

	@Autowired
	private CommercialService cs;
}
