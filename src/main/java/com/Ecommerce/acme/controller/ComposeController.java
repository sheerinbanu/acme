package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.ComposeService;

@Controller
public class ComposeController {

	@Autowired
	private ComposeService cs;
}
