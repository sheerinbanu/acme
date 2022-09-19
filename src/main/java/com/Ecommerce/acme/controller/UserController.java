package com.Ecommerce.acme.controller;

import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.service.CartService;
import com.Ecommerce.acme.service.OrderService;
import com.Ecommerce.acme.service.UserService;
import lombok.Data;


@Data
@Controller
public class UserController {


	@Autowired
	private UserService us;
	@GetMapping({"/admin/manage_user"}) 
	public String userProfile(Model model) {
		model.addAttribute("users",us.getAllUser()); 
		return "userProfile"; }

	@Autowired
	private OrderService os;
	@GetMapping({"/admin/manage_order"})
	public String Homepage(Model model) {
		model.addAttribute("orders",os.getAllOrder());
		return "orders";
	}

	@GetMapping("/admin/update_user/{id}")         
	public String updateUser(Model model, @ModelAttribute("user")User user, 
			@PathVariable(name = "id")  int id_user, BindingResult bindingResult){         
		Optional<User> user1 = us.getUser(id_user);          
		model.addAttribute("user", user1);        
		return "addUser";     }


	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	@GetMapping("/admin/add_user")
	public ModelAndView AddUser(Model model, @ModelAttribute("user")User user){
		ModelAndView mav = new ModelAndView("addUser");
		mav.addObject("addUser");
		return mav;
	}
	@PostMapping("/admin/add_user")
	public String Register(@ModelAttribute("user") User user, BindingResult bindingResult){
		us.insertUser(user);
		return "redirect:/admin/manage_user";
	}
	@GetMapping("/showUpdateForm/{id}")
	public String ShowUpdateForm(Model model, @ModelAttribute("user")User user, @PathVariable(name = "id")  int userId, BindingResult bindingResult){

		Optional<User> user1 = us.getUser(userId);

		model.addAttribute("user", user1);

		return "addUser";
	}


	@GetMapping("/admin/delete_user/{id}")
	public String DeleteUser(@PathVariable(name = "id") int id) {
		us.deleteUser(id);
		return "redirect:/admin/manage_user";
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
