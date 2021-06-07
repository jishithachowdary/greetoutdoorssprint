package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.CustomerEntity;
import com.greetotdoor.repository.ICustomerRepository;
import com.greetotdoor.service.ICustomerServiceImpl;

@RestController
public class CustomerController {
	@Autowired
	ICustomerServiceImpl cs;
	@RequestMapping("/customers")
	public List<CustomerEntity> getAllCustomers(){
		return cs.getAllCustomers();
	}
	@RequestMapping(method=RequestMethod.POST,value="/customer/insert")
	public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
		return cs.addCustomer(customer);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/customer/delete")
	public void removeCustomer(CustomerEntity customer) {
		cs.removeCustomer(customer);
	}
	@RequestMapping("/customer/id")
	public CustomerEntity viewCustomer(@RequestBody CustomerEntity customer) throws Exception {
		return cs.viewCustomer(customer);
	}
}
