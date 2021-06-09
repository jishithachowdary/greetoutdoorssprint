package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.exception.ProductException;
import com.greetotdoor.service.IProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
	private IProductServiceImpl ps;
	
	@RequestMapping(method=RequestMethod.POST,value="/product/insert")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		return ps.addProduct(productEntity);
	}
	@RequestMapping("/product/price/{maxPrice}")
	public List<ProductEntity> filter(@PathVariable double maxPrice){
		return ps.filter(maxPrice);
	}
	@RequestMapping("/product")
	public List<ProductEntity> findAllProducts(){
		return ps.findAllProducts();
	}
	@RequestMapping("/product/update")
	public ProductEntity updateProduct(@RequestBody ProductEntity productEntity) throws ProductException{
		return ps.updateProduct(productEntity);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/product/delete/{id}")
	public void deleteByProductId(@PathVariable String id) throws ProductException{
		ps.deleteByProductId(id);
	}
	@RequestMapping("/product/id/{id}")
	public ProductEntity findByProductId(@PathVariable String id) throws Exception{
		return ps.findByProductId(id);
	}
	@RequestMapping("/product/category/{productCategory}")
	public List<ProductEntity> findByProductCategory(@PathVariable String productCategory){
		return ps.findByProductCategory(productCategory);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/product/update/quantity/{quantity}/{productId} ")
	public void updateProductQuantity(@PathVariable int quantity,@PathVariable String productId) {
		ps.updateProductQuantity(quantity, productId);
	}
}
