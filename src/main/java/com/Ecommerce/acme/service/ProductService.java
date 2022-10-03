package com.Ecommerce.acme.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.repository.ProductRepository;
import lombok.Data;

@Data
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private SelectionService ss;	
	
	double reduction;
	double marginPrice;
	double finalPrice;
	
	public Optional<Product> getProduct(final int id){
		return pr.findById(id);
	}

	public Iterable<Product> getAllProduct() {
		return pr.findAll();
	}

	public void deleteProduct(final int id) {
		pr.deleteById(id);
	}
	
	public void insertProduct(Product Product) {
		pr.save(Product);
	}	
	
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