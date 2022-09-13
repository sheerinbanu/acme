package com.Ecommerce.acme.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.acme.model.Cart;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.CartService;
import com.Ecommerce.acme.service.SelectionService;
import com.Ecommerce.acme.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cs;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private SelectionService ss;
	
	double sum = 0;
	
	  @GetMapping({"/cart"})
	    public String getSelection(Model model) throws Exception {
		  
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/acme?useSSL=false", "root", "root");
		  Statement st = con.createStatement();
		  ResultSet res = st.executeQuery("SELECT SUM(total) FROM selection");
		  	  
		  model.addAttribute("selections", ss.getAllSelection());
		  model.addAttribute("person", us.findByType("commercial"));
		
		  while (res.next()) { 
			  sum = 0;
		
		      double c = (double) res.getInt(1);
		      sum = sum + c;  
		  }
		  
		  model.addAttribute("finalPrice", sum);
		  
	        return "cart";
	    }
	  
	  @PostMapping("/cart")
		public String submitCartForm(@ModelAttribute("cartForm") Cart cart, User user, Model model, BindingResult bindingResult) {
		  
		  cart.setValidate(true);
		  cart.setTotal_price(sum);
		  cart.setUser(user);
		 
		  cs.insertCart(cart);

		  return "products";
		}
	  
	 
}
