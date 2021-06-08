package com.greetotdoor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
