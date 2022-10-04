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
import org.springframework.web.bind.annotation.RequestParam;
import com.Ecommerce.acme.model.Category;
import com.Ecommerce.acme.model.Order;
import com.Ecommerce.acme.model.Product;
import com.Ecommerce.acme.model.User;
import com.Ecommerce.acme.repository.OrderRepository;
import com.Ecommerce.acme.service.AuthService;
import com.Ecommerce.acme.service.CategoryService;
import com.Ecommerce.acme.service.OrderService;
import com.Ecommerce.acme.service.ProductService;
import com.Ecommerce.acme.service.UserService;
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
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderRepository or;



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
	
	@GetMapping({"/admin/manage_user"}) 
	public String getAllUsersProfile(Model model) {
		model.addAttribute("users", userService.getAllUsers()); 
		return "manageUser";
	}

	@GetMapping("/admin/update_user/{id}")         
	public String getUser(Model model, @ModelAttribute("user")User user, @PathVariable(name = "id")  int id_user, BindingResult bindingResult){         
		Optional<User> user1 = userService.getUser(id_user);
		model.addAttribute("user", user1);        
		return "updateUser";     
		}
	
	@PostMapping("/admin/update_user/{id}")
	public String updateUser(@ModelAttribute User user) {
		userService.insertUser(user);
		return "redirect:/admin/manage_user";
	}
	
	@GetMapping("/admin/delete_user/{id}")
	public String DeleteUser(@PathVariable(name = "id") int id) {
		userService.removeUser(id);
		return "redirect:/admin/manage_user";
	}	
	
	@GetMapping("/admin/orders")
	public String ShowOrders(@ModelAttribute("orderForm") Order order, Model model) {
		model.addAttribute("orders", os.getAllOrder());
		return "adminOrders";
	}
	
	@GetMapping("/admin/orders/{id}")
	public String getSelectionByOrder(Model model, @ModelAttribute("selection")Order order, @PathVariable(name = "id") int Id_order){
		os.getDetailSelectionById(Id_order, model);
		return "AdminOrderDetails";
	}
	
	@PostMapping("/admin/orders")
	public String submitCartForm(@RequestParam("orderId") int orderId, @RequestParam("orderDate") String orderDate, @ModelAttribute("orderForm") Order order, Model model) {
		System.out.println(orderId);
		order.setId_order(orderId);
		order.setOrder_date(orderDate);
		order.setValidate(true);
		or.save(order);
		return "redirect:/admin/orders";
	}
}
