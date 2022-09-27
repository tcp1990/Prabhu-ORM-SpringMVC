package com.gl.crm.dao;

import java.util.List;

import com.gl.crm.model.Customer;

public interface CustomerDao {

	public void saveCustomer(Customer customer);

	public Customer findById(int id);

	public List<Customer> findAll();

	public void deleteCustomer(int id);

	public List<Customer> search(String firstName, String lastName);
}