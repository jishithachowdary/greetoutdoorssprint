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
	//getting the list of customers present
	@RequestMapping("/customers")
	public List<CustomerEntity> getAllCustomers(){
		return cs.getAllCustomers();
	}
	//inserting new customer to the customer list
	@RequestMapping(method=RequestMethod.POST,value="/customer/insert")
	public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
		return cs.addCustomer(customer);
	}
	//deleting customer from the customer list
	@RequestMapping(method=RequestMethod.DELETE,value="/customer/delete/")
	public void removeCustomer(@RequestBody CustomerEntity customer) {
		cs.removeCustomer(customer);
	}
	//getting the customer based on customer id
	@RequestMapping("/customer/id/")
	public CustomerEntity viewCustomer(@RequestBody CustomerEntity customer) throws Exception {
		return cs.viewCustomer(customer);
	}
	//updating the details of the customer 
	@RequestMapping(method=RequestMethod.PUT,value="/customer/update")
	public CustomerEntity updateCustomer(@RequestBody CustomerEntity customer) {
		return cs.updateCustomer(customer);
	}
}
