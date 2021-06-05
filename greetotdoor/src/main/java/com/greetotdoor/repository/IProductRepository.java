package com.greetotdoor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.greetotdoor.entities.ProductEntity;


@Service
public interface IProductRepository extends JpaRepository<ProductEntity,String>{
//	 List<ProductEntity> findAllProducts();
//
	 ProductEntity findByProductId(String id);
//
//	 List<ProductEntity> findByProductCategory(String productCategory);

//	 ProductEntity addProduct(ProductEntity productEntity) ;

//	 ProductEntity updateProduct(ProductEntity productEntity) throws ProductException;
//
//	 void updateProductQuantity(Integer quantity,String productId);
//
//	 void deleteByProductId(String id) throws ProductException;
//
//	 List<ProductEntity> search(String keyword);
//
//	 List<ProductEntity> filter(double maxPrice);
}
