package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.ProductException;
import com.greetotdoor.repository.IUserRepository;
import com.greetotdoor.service.IProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
	private IProductServiceImpl ps;
	@Autowired
	IUserRepository ur;
	@PreAuthorize("hasrole('admin')")
	@RequestMapping(method=RequestMethod.POST,value="/product/insert")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity,@PathVariable int userid) throws ProductException{
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
	@PreAuthorize("hasrole('admin')")
	@RequestMapping("/product/update")
	public ProductEntity updateProduct(@RequestBody ProductEntity productEntity) throws ProductException{
		return ps.updateProduct(productEntity);
		
	}
	@PreAuthorize("hasrole('admin')")
	@RequestMapping(method=RequestMethod.DELETE,value="/product/delete/{id}")
	public void deleteByProductId(@PathVariable String id) throws ProductException{
		ps.deleteByProductId(id);
	}
	@RequestMapping("/product/id/{id}")
	public ProductEntity findByProductId(@PathVariable String id) {
		return ps.findByProductId(id);
	}
	@RequestMapping("/product/category/{productCategory}")
	public List<ProductEntity> findByProductCategory(@PathVariable String productCategory){
		return ps.findByProductCategory(productCategory);
	}
	@PreAuthorize("hasrole('admin')")
	@RequestMapping(method=RequestMethod.PUT,value="/product/{quantity}/quantity/{productId}")
	public ProductEntity updateProductQuantity(@PathVariable int quantity,@PathVariable String productId) {
		System.out.println("reposiotiry");
		return ps.updateProductQuantity(quantity, productId);
	}
	@RequestMapping("/product/productname/{keyword}")
	public List<ProductEntity> search(@PathVariable String keyword){
		return ps.search(keyword);
	}
}
