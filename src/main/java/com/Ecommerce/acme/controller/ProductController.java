package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps;

	@GetMapping("/products")
	public String showProducts(Model model) {
		return ps.getListProduct(model);
	}

	@PostMapping("/products")
	public String addSelectToCart(Selection selection, User user, Product product, Authentication authentication, Model model, BindingResult bindingResult) {
		return ps.submitSelectionForm(selection, user, product, authentication, model, bindingResult);
	}

}
