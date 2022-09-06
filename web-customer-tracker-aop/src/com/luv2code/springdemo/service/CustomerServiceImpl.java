package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		
		customerDao.saveCustomer(customer);
	}

	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
		
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
		
	}
}
