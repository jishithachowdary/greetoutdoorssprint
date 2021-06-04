package com.greetotdoor.repository;

import java.time.LocalDate;
import java.util.List;

import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.exception.OrderException;

public interface IOrderRepository {
	 List<OrderEntity> findOrdersByUserId(String userId);
	 List<OrderEntity> findAllOrders();
	 OrderEntity addOrder(OrderEntity orderEntity) throws OrderException;
	 void deleteAllOrders() throws OrderException;
	 void deleteOrderById(String orderId) throws OrderException;
	 void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException;
}