package com.Ecommerce.acme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.AuthService;
import com.Ecommerce.acme.validator.UserValidator;


@Controller
public class AdminController {
	
	 @Autowired
	    private UserValidator userValidator;
	 
	 @Autowired
	    private AuthService authService;
	
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
	
}
