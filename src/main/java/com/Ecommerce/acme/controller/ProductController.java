package com.Ecommerce.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.repository.SelectionRepository;
import com.Ecommerce.acme.service.ProductService;
import com.Ecommerce.acme.service.SelectionService;
import com.Ecommerce.acme.service.UserService;

@Controller
public class ProductController {
	
	@Autowired
	private SelectionService ss;
	
	@Autowired
	private ProductService ps;
	
	static List<Integer> quantityList = null;
	static List<Integer> sizeList = null;
	
	static {
		quantityList = new ArrayList<>();
		quantityList.add(1);
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
	
	int totalSelection;
		
	@GetMapping("/products")
    public String getHomePage(Model model) {
		model.addAttribute("products", ps.getAllProduct());
        model.addAttribute("quantityList", quantityList);
        model.addAttribute("sizeList", sizeList);
    
        return "products";
    }
	
	@PostMapping("/products")
	public String submitSelectionForm(@ModelAttribute("selectionForm") Selection selection, Product product, Model model, BindingResult bindingResult) {
	
		totalSelection = selection.getQuantity() * product.getUnit_price();
		selection.setTotal(totalSelection);
		ss.insertSelection(selection);
		model.addAttribute("data", selection.toString());
		return "cart";
	}
		
}
