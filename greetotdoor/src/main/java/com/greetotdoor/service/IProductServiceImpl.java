package com.greetotdoor.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.ProductException;
import com.greetotdoor.repository.IProductRepository;



@Service
public class IProductServiceImpl implements IProductService{
	@Autowired	
	private IProductRepository pr;
	public ProductEntity addProduct(ProductEntity ProductEntity){
		ProductEntity p=new ProductEntity();
		p.setProductId(ProductEntity.getProductId());
		p.setProductName(ProductEntity.getProductName());
		p.setPrice(ProductEntity.getPrice());
		p.setCart(ProductEntity.getCart());
		p.setCategory(ProductEntity.getCategory());
		p.setColour(ProductEntity.getColour());
		p.setImage(ProductEntity.getImage());
		p.setOrder(ProductEntity.getOrder());
		p.setManufacturer(ProductEntity.getManufacturer());
		p.setQuantity(ProductEntity.getQuantity());
		p.setSpecification(ProductEntity.getSpecification());
		p.setWishlist(ProductEntity.getWishlist());
		return pr.save(p);
	}
	public ProductEntity findByProductId(String id) {
		for(ProductEntity p:pr.findAll()) {
			if(p.getProductId().equals(id)) {
				return p;
			}
		}
		return new ProductEntity();
	}
	public void deleteByProductId(String id) throws ProductException{
		if(pr.findById(id)!=null) {
			pr.deleteById(id);
		}else {
			throw new ProductException("no product available with given id");
		}
	}
	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException{
			ProductEntity p=pr.findById(productEntity.getProductId()).orElseThrow(()->new ProductException("no product available withe the given product id"));
			if(productEntity.getCart()!=null) {
				p.setCart(productEntity.getCart());
			}
			if(productEntity.getCategory()!=null) {
				p.setCategory(productEntity.getCategory());
			}
			if(productEntity.getColour()!=null) {
				p.setColour(productEntity.getColour());
			}
			if(productEntity.getImage()!=null) {
				p.setImage(productEntity.getImage());
			}
			if(productEntity.getManufacturer()!=null) {
				p.setManufacturer(productEntity.getManufacturer());
			}
			if(productEntity.getPrice()!=0) {
				p.setPrice(productEntity.getPrice());
			}
			if(productEntity.getOrder()!=null) {
				p.setOrder(productEntity.getOrder());
			}
			if(productEntity.getQuantity()!=0) {
				p.setQuantity(productEntity.getQuantity());
			}
			if(productEntity.getSpecification()!=null) {
				p.setSpecification(productEntity.getSpecification());
			}
			if(productEntity.getWishlist()!=null) {
				p.setWishlist(productEntity.getWishlist());
			}
			
			return pr.save(p);

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
	public List<ProductEntity> search(String keyword) {
		boolean isPresent;
		List<ProductEntity> p=new ArrayList<>();
		for(ProductEntity pe:pr.findAll())
		{
			isPresent=pe.getProductName().indexOf(keyword) != -1 ? true :false;
			
			if(isPresent)
			{
			
			if(pe.getProductName() != null && pe.getProductName().equals(keyword)) {
				p.add(pe);
			}
				
		}
		
	}
		return p;
}
	
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
	public ProductEntity updateProductQuantity(int quantity,String productId) {
		for(ProductEntity pe:pr.findAll()) {
			System.out.println(pe);
			if(pe.getProductId().equals(productId)) {
				System.out.println("inside");
				pe.setQuantity(quantity);
				return  pr.save(pe);
			}
		}
		return new ProductEntity();
	}
}
