package com.mdtsoft.service;

import java.util.List;

import com.mdtsoft.model.Customer;

public interface CustomerService {
	List<Customer> sortByName(List<Customer> customers);
}
