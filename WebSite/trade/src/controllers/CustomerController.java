package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Customer;
import service.UserService;

@Controller
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String listCustomers(Model model){
		
		List<Customer> theCustomers = userService.getCustomers();
		
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "user-form";
	}
}
