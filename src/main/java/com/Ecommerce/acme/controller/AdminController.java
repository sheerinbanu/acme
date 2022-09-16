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
import org.springframework.web.servlet.ModelAndView;

import com.Ecommerce.acme.model.Category;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.service.CategoryService;
import com.Ecommerce.acme.service.ProductService;


@Controller
public class AdminController {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private CategoryService cs;
		
	
	@GetMapping("/manageProduct")
	public String ManageController(Model model){
		model.addAttribute("products", ps.getAllProduct());
		return "manageProduct";
	}
	
	@GetMapping("/addProduct")
    public ModelAndView AddProduct(Model model, @ModelAttribute("product")Product product){
        ModelAndView mav = new ModelAndView("addProduct");
        model.addAttribute("categories", cs.getAllCategory());
        mav.addObject("addProduct");
        return mav;
    }

	@PostMapping("/addProduct")
	 public String RegisterProduct(@ModelAttribute("product") Product product, BindingResult bindingResult){
//		System.out.println(product.getCategory());
//		product.setCategory(category);
		ps.insertProduct(product);
		return "redirect:/manageProduct";
    }
	

	//Handler method for deleting a product from the application when it is no longer needed
	@GetMapping("/delete/{id}")
		public String DeleteProduct(@PathVariable(name = "id") int id) {
			ps.deleteProduct(id);
			return "redirect:/manageProduct";
	}
	
			
	@GetMapping("/updateProduct/{id}")
		public String UpdateProduct(Model model, @ModelAttribute("product")Product product, @PathVariable(name = "id")  int productId, BindingResult bindingResult){
			Optional<Product> product1 = ps.getProduct(productId);
		//	System.out.println(product1.get().getName());
			model.addAttribute("product", product1);
			model.addAttribute("categories", cs.getAllCategory());
//			mav.addObject("product", product1);
			return "addProduct";
	}
	
	@GetMapping("/manageCategory")
	public String ManageCategory(Model model){
		model.addAttribute("categories", cs.getAllCategory());
		return "manageCategory";
	}
	
	@GetMapping("/addCategory")
    public ModelAndView AddCategory(Model model, @ModelAttribute("category")Category category){
           ModelAndView mav = new ModelAndView("addCategory");
           mav.addObject("addCategory");
           return mav;
    }

	@PostMapping("/addCategory")
	 public String RegisterCategory(@ModelAttribute("category") Category category, BindingResult bindingResult){
//		System.out.println(product.getCategory());
//  	product.setCategory(category);
		cs.insertCategory(category);
		return "redirect:/manageCategory";
    }
	
	@GetMapping("/deleteCat/{id}")
	public String DeleteCategory(@PathVariable(name = "id") int id) {
		cs.deleteCategory(id);
		return "redirect:/manageCategory";
	}
	
	@GetMapping("/updateCategory/{id}")
	public String updateCategory(Model model, @ModelAttribute("category")Category category, @PathVariable(name = "id")  int id_category, BindingResult bindingResult){
		Optional<Category> category1 = cs.getCategory(id_category);
	//	System.out.println(product1.get().getName());
		model.addAttribute("category", category1);
		
//		mav.addObject("product", product1);
		return "addCategory";
	}
	
}
