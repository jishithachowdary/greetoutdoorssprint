package com.greetotdoor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;
import com.greetotdoor.service.ICartServiceImpl;


@RestController
public class CartController {
	@Autowired
	private ICartServiceImpl cs;
	
	@RequestMapping(method=RequestMethod.POST,value="/cart/insert")
	public void addCart(@RequestBody CartRequest crequest) throws CartException {
		 cs.addCart(crequest);
	}

}
