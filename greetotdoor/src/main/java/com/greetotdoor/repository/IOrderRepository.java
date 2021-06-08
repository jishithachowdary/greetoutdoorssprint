package com.greetotdoor.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.exception.OrderException;

@Service
public interface IOrderRepository extends JpaRepository<OrderEntity,String>{
//	 List<OrderEntity> findOrdersByUserId(String userId);
//	 List<OrderEntity> findAllOrders();

//	 void deleteAllOrders() throws OrderException;
//	 void deleteOrderById(String orderId) throws OrderException;
//	 void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException;
}