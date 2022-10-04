package com.Ecommerce.acme.controller;

import java.util.ArrayList;
import java.util.List;
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

	static List<Integer> quantityList = null;
	static List<Integer> sizeList = null;

	static {
		quantityList = new ArrayList<>();
		quantityList.add(1);
		quantityList.add(10);
		quantityList.add(50);
		quantityList.add(100);
	}

	static {
		sizeList = new ArrayList<>();
		sizeList.add(41);
		sizeList.add(42);
		sizeList.add(43);
		sizeList.add(44);
		sizeList.add(45);
		sizeList.add(46);
	}

	@GetMapping("/products")
	public String getHomePage(Model model) {
		model.addAttribute("products", ps.getAllProduct());
		model.addAttribute("quantityList", quantityList);
		model.addAttribute("sizeList", sizeList);

		return "products";
	}

	@PostMapping("/products")
	public String addSelectToCart(Selection selection, User user, Product product, Authentication authentication, Model model, BindingResult bindingResult) {
		return ps.submitSelectionForm(selection, user, product, authentication, model, bindingResult);
	}

}
