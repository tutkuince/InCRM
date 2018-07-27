package com.mdtsoft.service;

import java.util.List;

import com.mdtsoft.model.Customer;

public interface CustomerService {
	void insert(Customer customer);
	Customer getById(int id);
	List<Customer> getAll();
	void update(int id);
	void delete(int id);
	List<Customer> sortByName(List<Customer> customers);
}
