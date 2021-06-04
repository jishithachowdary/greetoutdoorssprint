package com.greetotdoor.repository;

import java.time.LocalDate;
import java.util.List;

import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.exception.OrderException;

public interface IOrderRepository {
	public List<OrderEntity> findOrdersByUserId(String userId);
	public List<OrderEntity> findAllOrders();
	public OrderEntity addOrder(OrderEntity orderEntity) throws OrderException;
	public void deleteAllOrders() throws OrderException;
	public void deleteOrderById(String orderId) throws OrderException;
	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException;
}