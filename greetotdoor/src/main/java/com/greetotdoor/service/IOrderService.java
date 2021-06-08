package com.greetotdoor.service;

import java.time.LocalDate;
import java.util.List;

import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.exception.OrderException;
import com.greetotdoor.pojos.OrderRequest;

public interface IOrderService {

//	public List<OrderEntity> findOrdersByUserId(String userId);
//
//	public List<OrderEntity> findAllOrders();

	public void addOrder(OrderRequest orequest) throws OrderException;

//	public void deleteAllOrders() throws OrderException;
//
//	public void deleteOrderById(String orderId) throws OrderException;
//
//	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException;

}
