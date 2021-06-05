package com.greetotdoor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.service.IProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
	private IProductServiceImpl ps;
	
	@RequestMapping(method=RequestMethod.POST,value="/product/insert")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		return ps.addProduct(productEntity);
	}
	
}
