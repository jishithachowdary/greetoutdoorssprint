package com.greetotdoor.service;

import java.util.List;

import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.exception.ProductException;



public interface IProductService {

	public List<ProductEntity> findAllProducts();

	public ProductEntity findByProductId(String id);

	public List<ProductEntity> findByProductCategory(String productCategory);

	public ProductEntity addProduct(ProductEntity productEntity) ;

	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException;

	public ProductEntity updateProductQuantity(int quantity,String productId);

	public void deleteByProductId(String id) throws ProductException;

	public List<ProductEntity> search(String keyword);

	public List<ProductEntity> filter(double maxPrice);

}
