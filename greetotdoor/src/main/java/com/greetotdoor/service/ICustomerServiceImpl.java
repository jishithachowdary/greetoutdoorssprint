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
		for(CustomerEntity c:cr.findAll()) {
			if(c.getCustomerId()==customer.getCustomerId()) {
				if(customer.getCustomerName()!=null) {
				c.setCustomerName(customer.getCustomerName());
				}
				if(customer.getEmail()!=null) {
				c.setEmail(customer.getEmail());
				}
				if(customer.getMobileNo()!=null) {
				c.setMobileNo(customer.getMobileNo());
				}if(customer.getAddress()!=null) {
				c.setAddress(customer.getAddress());
				}
				return cr.save(c);
			}
		}
		return new CustomerEntity();
	}
	public void removeCustomer(CustomerEntity customer) {
		 cr.deleteById(customer.getCustomerId());
	}
	public CustomerEntity viewCustomer(CustomerEntity customer)  throws Exception{
		return cr.findById(customer.getCustomerId()).orElseThrow(()->new Exception("there is no customer with particular customer id"));
	}
}
