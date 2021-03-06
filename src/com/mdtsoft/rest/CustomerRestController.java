package com.mdtsoft.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtsoft.model.Customer;
import com.mdtsoft.rest.error.CustomerNotFoundException;
import com.mdtsoft.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getAll();
	}

	// add mapping for GET /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getById(customerId);

		if (customer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);

		return customer;
	}

	// add mapping for POST /customers - add new customer
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {

		customer.setId(0);
		customerService.save(customer);

		return customer;
	}

	// add mapping for PUT /customers - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);

		return customer;
	}

	// add mapping for DELETE /customers/{customerId} - delete customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer customer = customerService.getById(customerId);
		
		// throw exception if customer is null
		if(customer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		
		customerService.delete(customerId);
		
		return "Deleted customer id - "+ customerId;
	}

}
