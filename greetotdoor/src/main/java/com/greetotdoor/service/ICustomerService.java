package com.greetotdoor.service;

import java.util.List;

import com.greetotdoor.entities.CustomerEntity;


public interface ICustomerService {
	public List<CustomerEntity> getAllCustomers();
	public CustomerEntity addCustomer(CustomerEntity customer);
	public CustomerEntity updateCustomer(CustomerEntity customer);
	public void removeCustomer(CustomerEntity customer);
	public CustomerEntity viewCustomer(CustomerEntity customer)  throws Exception;
}
