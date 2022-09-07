 package com.Ecommerce.acme.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.UserService;
import lombok.Data;

@Data
@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		
		User oauthUser = us.login(user.getEmail(), user.getPassword());
		
		if(Objects.nonNull(oauthUser)) {
			
			return "redirect:/";
			
		} else {
			
			return "redirect:/login";
			
		}
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	public String logOutDo(HttpServletRequest request, HttpServletResponse response) {
		
		return "redirect:/login";
		
	}
}
