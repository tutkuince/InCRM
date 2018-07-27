package com.mdtsoft.dao;

import java.util.List;

import com.mdtsoft.model.Customer;

public interface CustomerDAO {
	void save(Customer customer);
	Customer getById(int id);
	List<Customer> getAll();
	void delete(int id);
}
