package com.greetotdoor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.ProductEntity;


@Service
public interface IProductRepository extends JpaRepository<ProductEntity,String>{
	 ProductEntity findByProductId(String id);
}
