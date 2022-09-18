package com.Ecommerce.acme.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.Ecommerce.acme.model.Cart;
import com.Ecommerce.acme.model.Order;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.CartService;
import com.Ecommerce.acme.service.OrderService;
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

	@Autowired
	private OrderService os;

	double sum = 0;

	@GetMapping({"/cart"})
	public String getSelection(Model model, User user, Authentication authentication )  throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/acme?useSSL=false", "root", "root");
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT SUM(total) FROM selection WHERE id_cart is null ");

		int currentUserId = us.findByUsername(authentication.getName()).getId_user();
		ArrayList<Selection> list = new ArrayList<Selection>();

		for(Selection s : ss.getAllSelection()) {

			if(s.getCart() == null && s.getId_user() == currentUserId) {

				list.add(s);

			}		 
		}

		model.addAttribute("selections", list);
		model.addAttribute("person", us.findByUsername(authentication.getName()));

		while (res.next()) { 
			sum = 0;

			double c = (double) res.getInt(1);
			System.out.println(res.getInt(1));
			sum = sum + c;  
		}

		model.addAttribute("finalPrice", sum);

		return "cart";
	}

	@PostMapping("/cart")
	public String submitCartForm(@ModelAttribute("cartForm") Cart cart, Order order, Selection selection, User user, Authentication authentication, Model model, BindingResult bindingResult) {

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		int currentUserId = us.findByUsername(authentication.getName()).getId_user();

		
		cart.setTotal_price(sum);
		cart.setUser(user);

		cs.insertCart(cart);

		for(Selection s : ss.getAllSelection()) {

			if(s.getCart() == null  && s.getId_user() == currentUserId) {

				s.setCart(cart);
				ss.insertSelection(s);
			}
		}

		order.setCart(cart);
		order.setOrder_date(formattedDate);
		order.setUser(user);
		order.setValidate(false);
		
		os.insertOrder(order);

		return "redirect:/cart";
	}

}
