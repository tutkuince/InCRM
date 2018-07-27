package com.mdtsoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mdtsoft.model.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// @Transactional move to service layer
	public List<Customer> getAll() {

		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		// execute the query and get result list
		List<Customer> customerList = query.getResultList();

		// return the results
		return customerList;
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
