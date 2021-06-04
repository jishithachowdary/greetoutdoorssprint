package com.greetotdoor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greetotdoor.entities.CustomerEntity;
import com.greetotdoor.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService{
	private ICustomerRepository cr;
	public List<CustomerEntity> getAllCustomers(){
		return cr.findAll();
	}
	public CustomerEntity addCustomer(CustomerEntity customer) {
		return cr.save(customer);
	}
	public CustomerEntity updateCustomer(CustomerEntity customer) {
		return cr.save(customer);
	}
	public void removeCustomer(CustomerEntity customer) {
		 cr.deleteById(customer.getCustomer_id());
	}
	public CustomerEntity viewCustomer(CustomerEntity customer) throws Exception {
		return cr.findById(customer.getCustomer_id()).orElseThrow(()->new Exception("Customer not found"));
	}
}
