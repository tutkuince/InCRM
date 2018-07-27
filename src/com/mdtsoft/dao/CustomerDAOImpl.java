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
	public void save(Customer customer) {
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// save the customer
		// session.save(customer);

		// saveOrUpdate() -> if PK empty then INSERT new customer
		// else UPDATE exiting customer
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getById(int id) {
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// read from database using the primary key
		return session.get(Customer.class, id);
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
	public void delete(int id) {
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = getById(id);

		// Query q = session.createQuery("delete from Customer where id=:id");
		// q.setParameter("id", id);
		// q.executeUpdate();
		
		session.delete(customer);
	}

}
