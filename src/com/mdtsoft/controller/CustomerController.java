package com.mdtsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdtsoft.dao.CustomerDAO;
import com.mdtsoft.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		// get customers from the dao
		List<Customer> customerList = customerDAO.getAll();
		
		//  add the customers to the model
		model.addAttribute("customerList", customerList);

		return "list-customers";
	}
}
