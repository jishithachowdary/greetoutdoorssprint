package com.greetotdoor.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.exception.ProductException;
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
	public void deleteByProductId(String id) throws ProductException{
		 pr.deleteById(id);
	}
	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException{
		return pr.save(productEntity);
	}
	public List<ProductEntity> filter(double maxPrice) {
		List<ProductEntity> p=new ArrayList<>();
		for(ProductEntity pe:pr.findAll()) {
			if(pe.getPrice()>=maxPrice) {
				p.add(pe);
			}
		}
		return p;
	}
//	public List<ProductEntity> search(String keyword) {
//		// TODO Auto-generated method stub
//		if (keyword != null)
//		{
//			pr.search(keyword);
//		}
//		return pr.findAll();
//	}
	public List<ProductEntity> findAllProducts(){
		return pr.findAll();
	}
	public List<ProductEntity> findByProductCategory(String productCategory){
		List<ProductEntity> p=new ArrayList<>();
		for(ProductEntity pe:pr.findAll())
		{
			if(pe.getCategory()!=null) {
				if(pe.getCategory().equals(productCategory))
				{
					p.add(pe);
				}
			}
		}
		return p;
	}
	public void updateProductQuantity(int quantity,String productId) {
		for(ProductEntity pe:pr.findAll()) {
			
			if(pe.getProductId().equals(productId)) {
				pe.setQuantity(quantity);
				pr.save(pe);
			}
		}
	}
}
