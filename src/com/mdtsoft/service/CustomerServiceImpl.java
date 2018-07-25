package com.mdtsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtsoft.dao.CustomerDAO;
import com.mdtsoft.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> sortByName(List<Customer> customers) {
		customers = customerDAO.getAll();
		customers.sort((Customer c1, Customer c2) -> c1.getFirstName().compareTo(c2.getFirstName()));
		return customers;
	}

}
