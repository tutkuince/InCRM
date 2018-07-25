package com.mdtsoft.dao;

import java.util.List;

import com.mdtsoft.model.Customer;

public interface CustomerDAO {
	void insert(Customer customer);
	Customer getById(int id);
	List<Customer> getAll();
	void update(int id);
	void delete(int id);
}
