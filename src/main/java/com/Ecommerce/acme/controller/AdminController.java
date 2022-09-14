package com.Ecommerce.acme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Ecommerce.acme.model.Category;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.repository.ProductRepository;
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
    public ModelAndView AddProduct(Model model, @ModelAttribute("productForm")Product product){
        ModelAndView mav = new ModelAndView("addProduct");
        model.addAttribute("categories", cs.getAllCategory());
        mav.addObject("addProduct");
        return mav;
    }

	@PostMapping("/addProduct")
	 public String Register(@ModelAttribute("productForm") Product product, BindingResult bindingResult){
		System.out.println(product.getCategory());
//		product.setCategory(category);
		ps.insertProduct(product);
		
        return "redirect:/manageProduct";
    }
	

	@GetMapping("/archive")
    public ModelAndView Archive(Model model){
        ModelAndView mav = new ModelAndView("archive");
        mav.addObject("archive");
        return mav;
    }

}
