 package com.Ecommerce.acme.controller;
 
 
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.AuthService;
import com.Ecommerce.acme.service.CartService;
import com.Ecommerce.acme.service.UserService;
import com.Ecommerce.acme.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

 
@Controller
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
            
        }

        authService.createNewUser(userForm);


        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your username or password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/home"})
    public String welcome(Model model) {
        return "index";
    }
    
    @GetMapping({"/profil"})
    public String profil(Model model, Authentication authentication) {
    	model.addAttribute("person", userService.findByUsername(authentication.getName()));
        return "profil";
    }

   
}