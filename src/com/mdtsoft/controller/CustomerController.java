package com.mdtsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdtsoft.model.Customer;
import com.mdtsoft.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

//	@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model) {

		// get customers from the CustomerService
		List<Customer> customerList = customerService.getAll();

		// add the customers to the model
		model.addAttribute("customerList", customerList);

		return "list-customers";
	}
	
	@GetMapping("/orderedList")
	public String orderedListCustomers(Model model) {

		// get customers from the CustomerService
		List<Customer> customerList = customerService.sortByName();

		// add the customers to the model
		model.addAttribute("customerList", customerList);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.insert(customer);
		return "redirect:/customer/list";
	}
}
