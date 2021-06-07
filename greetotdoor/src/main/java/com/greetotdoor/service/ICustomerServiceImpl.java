package com.greetotdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.AddressEntity;
import com.greetotdoor.entities.CustomerEntity;
import com.greetotdoor.repository.AddressRepository;
import com.greetotdoor.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerRepository cr;
	@Autowired
	AddressRepository ar;
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
	public CustomerEntity viewCustomer(CustomerEntity customer) {
		return cr.viewCustomer(customer);
	}
}
