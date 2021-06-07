package com.greetotdoor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.CustomerEntity;

@Service
public interface ICustomerRepository extends JpaRepository<CustomerEntity,Integer>{
	 @Query(name="Customer.getById")
	 CustomerEntity viewCustomer(CustomerEntity customer);

}