package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.CommandeService;

@Controller
public class CommandeController {

	@Autowired
	private CommandeService cs;
}
