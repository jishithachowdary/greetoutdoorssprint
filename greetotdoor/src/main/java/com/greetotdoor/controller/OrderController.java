package com.greetotdoor.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.dao.OrderDao;
import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.exception.OrderException;
import com.greetotdoor.pojos.OrderRequest;
import com.greetotdoor.service.IOrderServiceImpl;

@RestController
public class OrderController {
	@Autowired
	IOrderServiceImpl os;
	@RequestMapping(method=RequestMethod.POST,value="/order/insert")
	public void addOrder(@RequestBody OrderRequest orequest) throws OrderException{
		os.addOrder(orequest);
	}
	@RequestMapping("/orders")
	public List<OrderDao> findAllOrders(){
		return os.findAllOrders();
	}
	@RequestMapping("/ordersById/{userId}")
	public List<OrderDao> findOrdersByUserId(@PathVariable String userId){
		return os.findOrdersByUserId(userId);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/order/deleteById/{orderId}")
	public void deleteOrderById(@PathVariable String orderId) throws OrderException{
		os.deleteOrderById(orderId);
	}
	@RequestMapping(method=RequestMethod.PUT,value="order/update/{orderId}/dispatch/{dispatchDate}/arrival/{arrivalDate}")
	public void updateDate(@PathVariable String orderId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dispatchDate,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arrivalDate) throws OrderException{
		os.updateDate(orderId, dispatchDate, arrivalDate);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/order/delete")
	public void deleteAllOrders() throws OrderException{
		os.deleteAllOrders();
	}
}
