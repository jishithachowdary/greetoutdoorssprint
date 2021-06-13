package com.greetotdoor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.repository.IProductRepository;

@SpringBootTest
class IProductServiceImplTest2 {
	@InjectMocks
	IProductServiceImpl service;
	@Mock
	IProductRepository pr;


	@Test
	void testFindByProductId() {
		ProductEntity act=service.findByProductId("1001");
		assertNotNull(act);
	}



	@Test
	void testFilter() {
		List<ProductEntity> prod=new ArrayList<>();
		for(ProductEntity p1:service.filter(800)) {
			prod.add(p1);
		}
		assertNotNull(prod);
	}

	@Test
	void testFindAllProducts() {
		List<ProductEntity> prod=new ArrayList<>();
		for(ProductEntity p1:service.findAllProducts()) {
			prod.add(p1);
		}
		assertNotNull(prod);
	}

	@Test
	void testFindByProductCategory() {
		List<ProductEntity> prod=new ArrayList<>();
		for(ProductEntity p1:service.findByProductCategory("mobile")) {
			prod.add(p1);
		}
		assertNotNull(prod);
	}

	@Test
	void testUpdateProductQuantity() {
		ProductEntity pe=service.updateProductQuantity(30,"1003");
		assertNotNull(pe);
	}

}
