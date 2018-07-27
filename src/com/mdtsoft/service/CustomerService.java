package com.mdtsoft.service;

import java.util.List;

import com.mdtsoft.model.Customer;

public interface CustomerService {
	void save(Customer customer);
	Customer getById(int id);
	List<Customer> getAll();
	void delete(int id);
	List<Customer> sortByName();
	List<Customer> searchCustomerByName(String name);
}
