package com.mdtsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdtsoft.dao.CustomerDAO;
import com.mdtsoft.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> sortByName() {
		List<Customer> customers = customerDAO.getAll();
		customers.sort((Customer c1, Customer c2) -> c1.getFirstName().compareTo(c2.getFirstName()));
		return customers;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	@Transactional
	public Customer getById(int id) {
		return customerDAO.getById(id);
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDAO.delete(id);
	}

}
