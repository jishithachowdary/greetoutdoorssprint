package com.greetotdoor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.repository.IProductRepository;

@Service
public class IProductServiceImpl implements IProductService{
		
	@Autowired	
	private IProductRepository pr;
	public ProductEntity addProduct(ProductEntity productEntity){
		return pr.save(productEntity);
	}
	public ProductEntity findByProductId(String id) throws Exception{
		return pr.findById(id).orElseThrow(()->new Exception("Element not found"));
	}
}
