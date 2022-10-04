package com.Ecommerce.acme.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.Ecommerce.acme.model.Cart;
import com.Ecommerce.acme.model.Order;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.repository.CartRepository;

import lombok.Data;

@Data
@Service
public class CartService {
	
	@Autowired
	private UserService us;

	@Autowired
	private SelectionService ss;

	@Autowired
	private OrderService os;
	
	@Autowired
	private CartRepository cr;
	
	public Optional<Cart> getCart(final int id){
		return cr.findById(id);
	}

	public Iterable<Cart> getAllCart() {
		return cr.findAll();
	}

	public void deleteCart(final int id) {
		cr.deleteById(id);
	}
	
	public void insertCart(Cart Cart) {
		cr.save(Cart);
	}
	
	public String getSelection(Model model, User user, Authentication authentication )  throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme?useSSL=false", "root", "root");
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT SUM(total) FROM selection WHERE id_cart is null ");

		int currentUserId = us.findByUsername(authentication.getName()).getId_user();
		ArrayList<Selection> list = new ArrayList<Selection>();
		double sum = 0;

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
	
	public String submitCartForm(@ModelAttribute("cartForm") Cart cart, Order order, Selection selection, User user, Authentication authentication, Model model, BindingResult bindingResult) {

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		int currentUserId = us.findByUsername(authentication.getName()).getId_user();

		cart.setUser(user);

		insertCart(cart);

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
