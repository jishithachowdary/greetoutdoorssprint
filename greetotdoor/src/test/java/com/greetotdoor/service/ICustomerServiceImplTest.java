package com.greetotdoor.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.greetotdoor.entities.AddressEntity;
import com.greetotdoor.entities.CustomerEntity;
import com.greetotdoor.repository.ICustomerRepository;


@SpringBootTest
class ICustomerServiceImplTest {
	CustomerEntity c=mock(CustomerEntity.class);
	@InjectMocks
	ICustomerServiceImpl service;
	@Mock
	ICustomerRepository repository;
	@Test
	void testGetAllCustomers() {
		Set<AddressEntity> address=new HashSet<>();
		address.add(new AddressEntity(1075,2,"kalapu center","radam center","madapeta","andhra pradesh","533308"));
		Set<AddressEntity> address1=new HashSet<>();
		address1.add(new AddressEntity(1077,19,"bukka center","radam center","mandapeta","andhra pradesh","533308"));
		CustomerEntity customer=new CustomerEntity(1074,"chowdary","9989626566","nkiranvsmac@gmail.com",address);
		CustomerEntity customer1=new CustomerEntity(1076,"nemani","8688626111","nnemanijc@gmail.com",address1);
		List<CustomerEntity> customerList = new ArrayList<>();
		customerList.add(customer);
		customerList.add(customer1);
		Mockito.when(service.getAllCustomers()).thenReturn(customerList);
		List<CustomerEntity> act = service.getAllCustomers();
		assertEquals(customerList.size(),act.size());
	}


	@Test
	void testAddCustomer() {
		Set<AddressEntity> address=new HashSet<>();
		address.add(new AddressEntity(1,21,"bukka vari street","radam center","mandapeta","andhra pradesh","533308"));
		CustomerEntity customer=new CustomerEntity(1,"jishitha","8688626111","nemanijc@gmail.com",address);
		Mockito.when(service.addCustomer(customer)).thenReturn(customer);
		CustomerEntity act=service.addCustomer(customer);
		assertEquals(customer,act);
	}

	@Test
	void testUpdateCustomer() {
		Set<AddressEntity> address=new HashSet<>();
		address.add(new AddressEntity(1,21,"bukka vari street","radam center","mandapeta","andhra pradesh","533308"));
		address.add(new AddressEntity(2,31,"kalkinagar 2","ags colony","chennai","tanilnadu","600042"));
		CustomerEntity customer=new CustomerEntity(1,"jishitha","8688626111","nemanijc@gmail.com",address);
		Mockito.when(service.addCustomer(customer)).thenReturn(customer);
		CustomerEntity act=service.addCustomer(customer);
		assertEquals(customer,act);
	}

	
	
	

}
