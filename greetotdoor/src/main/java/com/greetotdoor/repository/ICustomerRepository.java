package com.greetotdoor.repository;

import java.util.List;

import com.greetotdoor.entities.CustomerEntity;

public interface ICustomerRepository {

	public List<CustomerEntity> getAllCustomers();
	public CustomerEntity addCustomer(CustomerEntity customer);
	public CustomerEntity updateCustomer(CustomerEntity customer);
	public CustomerEntity removeCustomer(CustomerEntity customer);
	public CustomerEntity viewCustomer(CustomerEntity customer);

}