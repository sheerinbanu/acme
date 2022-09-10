 package com.Ecommerce.acme.controller;
 
 import com.Ecommerce.acme.model.User;
 import com.Ecommerce.acme.service.SecurityService;
 import com.Ecommerce.acme.service.UserService;
 import com.Ecommerce.acme.validator.UserValidator;

 import org.springframework.beans.factory.annotation.Autowired;
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
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/home"})
    public String welcome(Model model) {
        return "Homepage";
    }
    
    @GetMapping({"/profil"})
    public String profil(Model model) {
    	model.addAttribute("person", userService.findByUsername("commercial"));
        return "profil";
    }

    @GetMapping("/addAdmin")
    public String admin(@ModelAttribute("userForm") User userForm) {
        return "admin";
    }

    @PostMapping("/addAdmin")
    public String admin(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "admin";
        }

        userService.saveAsAdmin(userForm);

        model.addAttribute("success_message", "New admin account successfully created");
        model.addAttribute("has_success", true);

        return "admin";
    }
}