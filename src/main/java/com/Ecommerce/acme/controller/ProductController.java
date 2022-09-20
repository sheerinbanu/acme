package com.Ecommerce.acme.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.CartService;
import com.Ecommerce.acme.service.ProductService;
import com.Ecommerce.acme.service.SelectionService;
import com.Ecommerce.acme.service.UserService;

@Controller
public class ProductController {

	@Autowired
	private SelectionService ss;

	@Autowired
	private UserService us;

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

	double reduction;
	double marginPrice;
	double finalPrice;

	@GetMapping("/products")
	public String getHomePage(Model model) {
		model.addAttribute("products", ps.getAllProduct());
		model.addAttribute("quantityList", quantityList);
		model.addAttribute("sizeList", sizeList);

		return "products";
	}

	@PostMapping("/products")
	public String submitSelectionForm(@ModelAttribute("selectionForm") Selection selection,User user, Product product, Authentication authentication, Model model, BindingResult bindingResult){

		int currentUserMarge = us.findByUsername(authentication.getName()).getMargin_rate();
		int currentUserId = us.findByUsername(authentication.getName()).getId_user();

		Double marge = (currentUserMarge / 100.0);
		reduction = (product.getUnit_price() * marge);
		marginPrice = (product.getUnit_price() - reduction); 
		Double totalSelection = (marginPrice * selection.getQuantity());

		selection.setMargin_price(marginPrice);
		selection.setTotal(totalSelection);
		selection.setId_user(currentUserId);

		ss.insertSelection(selection);

		return "redirect:/products";
	}


}
