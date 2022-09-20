package com.Ecommerce.acme.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Ecommerce.acme.model.Category;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.AuthService;
import com.Ecommerce.acme.service.CategoryService;
import com.Ecommerce.acme.service.ProductService;
import com.Ecommerce.acme.validator.UserValidator;


@Controller
public class AdminController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private AuthService authService;

	@Autowired
	private ProductService ps;

	@Autowired
	private CategoryService cs;



	@GetMapping("/admin/addAdmin")
	public String admin(@ModelAttribute("userForm") User userForm) {
		return "admin";
	}

	@PostMapping("/admin/addAdmin")
	public String admin(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "admin";
		}

		authService.createNewAdmin(userForm);

		model.addAttribute("success_message", "New admin account successfully created");
		model.addAttribute("has_success", true);

		return "admin";
	}

	@GetMapping("/admin/manage_product")
	public String ManageController(Model model){
		model.addAttribute("products", ps.getAllProduct());
		return "manageProduct";
	}
	
	@GetMapping("/admin/add_product")
    public String AddProduct(Model model, @ModelAttribute("product")Product product){
        model.addAttribute("categories", cs.getAllCategory());
        return "addProduct";
    }

	@PostMapping("/admin/add_product")
	 public String RegisterProduct(@ModelAttribute("product") Product product){
		ps.insertProduct(product);
		return "redirect:/admin/manage_product";
    }
	
	@GetMapping("/admin/delete_product/{id}")
		public String DeleteProduct(@PathVariable(name = "id") int id) {
			ps.deleteProduct(id);
			return "redirect:/admin/manage_product";
	}
	
			
	@GetMapping("/admin/update_product/{id}")
		public String UpdateProduct(Model model, @ModelAttribute("product")Product product, @PathVariable(name = "id")  int productId, BindingResult bindingResult){
			Optional<Product> product1 = ps.getProduct(productId);
			model.addAttribute("product", product1);
			model.addAttribute("categories", cs.getAllCategory());
			return "addProduct";
	}
	
	@GetMapping("/admin/manage_category")
	public String ManageCategory(Model model){
		model.addAttribute("categories", cs.getAllCategory());
		return "manageCategory";
	}
	
	@GetMapping("/admin/add_category")
    public String AddCategory(Model model, @ModelAttribute("category")Category category){
           return "addCategory";
    }

	@PostMapping("/admin/add_category")
	 public String RegisterCategory(@ModelAttribute("category") Category category){
		cs.insertCategory(category);
		return "redirect:/admin/manage_category";
    }
	
	@GetMapping("/admin/delete_category/{id}")
	public String DeleteCategory(@PathVariable(name = "id") int id) {
		cs.deleteCategory(id);
		return "redirect:/admin/manage_category";
	}
	
	@GetMapping("/admin/update_category/{id}")
	public String updateCategory(Model model, @ModelAttribute("category")Category category, @PathVariable(name = "id")  int id_category, BindingResult bindingResult){
		Optional<Category> category1 = cs.getCategory(id_category);
		model.addAttribute("category", category1);
		return "addCategory";
	}

}
