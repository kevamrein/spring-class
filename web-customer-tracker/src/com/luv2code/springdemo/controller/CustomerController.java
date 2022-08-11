package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/customer/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/customer/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
}
