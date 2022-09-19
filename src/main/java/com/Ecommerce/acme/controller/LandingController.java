package com.Ecommerce.acme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

	@GetMapping("/landingPage")
	public String landingPage(Model model) {
		return "landingPage";
	}
	

}

