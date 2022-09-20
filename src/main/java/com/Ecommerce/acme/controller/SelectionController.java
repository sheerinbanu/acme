package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.Ecommerce.acme.service.SelectionService;

@Controller
public class SelectionController {

	@Autowired
	private SelectionService ss;

	@GetMapping("/cart/{id}")
	public String DeleteProduct(@PathVariable(name = "id") int id) {
		ss.deleteSelection(id);
		return "redirect:/cart";
	}

}
