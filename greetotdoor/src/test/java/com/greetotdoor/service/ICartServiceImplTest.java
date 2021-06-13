package com.greetotdoor.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.greetotdoor.dao.CartDao;
import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;
import com.greetotdoor.repository.ICartRepository;

@SpringBootTest
class ICartServiceImplTest {
	@InjectMocks
	ICartServiceImpl cs;
	@Mock
	ICartRepository cr;

	@Test
	void testFindCartlist() {
		List<CartDao> cart=new ArrayList<>();
		for(CartDao c1:cs.findCartlist("1001")){
			cart.add(c1);
		}
		assertNotNull(cart);
	}

	@Test
	void testFindCartItem() {
		CartDao act=cs.findCartItem("1001","1001");
		assertNotNull(act);
		
	}

	@Test
	void testUpdateCart() throws CartException {
		List<CartItemEntity> cartDao=new ArrayList<>();
		Map<String,ProductEntity> p=new HashMap<>();
		ProductEntity pd=new ProductEntity("1001","hp",1000,"hp",null,"laptop",15,null,"intel i5");
		p.put("hp", pd);
		ProductEntity pd1=new ProductEntity("1002","dell",900,"dell",null,"laptop",18,null,"intel i5");
		p.put("dell", pd1);
		CartRequest c=new CartRequest(1100,"jishitha",2000,2,p);
		CartItemEntity act=cs.updateCart(c);
		assertNotNull(act);
		
	}

}
