package com.gl.crm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.crm.model.Customer;

@Repository
public class CustomerDoaImpl implements CustomerDao {

	@Autowired
	SessionFactory factory;

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public Customer findById(int id) {
		Session session = factory.getCurrentSession();
		Customer cust = session.get(Customer.class, id);
		System.out.println(cust);
		return cust;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session = factory.getCurrentSession();
		Customer cust = session.load(Customer.class, id);
		session.delete(cust);

	}

	@Override
	@Transactional
	public List<Customer> search(String name, String department) {
		Session session = factory.getCurrentSession();
		Criteria c = session.createCriteria(Customer.class);
		Criterion n = Restrictions.eq("name", name);
		Criterion d = Restrictions.eq("department", department);
		Criterion combine = Restrictions.and(n, d);
		c.add(combine);
		return c.list();
	}

}
