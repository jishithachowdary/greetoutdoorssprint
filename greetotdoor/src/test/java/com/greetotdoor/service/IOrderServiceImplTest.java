package com.greetotdoor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.greetotdoor.dao.OrderDao;
import com.greetotdoor.repository.IOrderRepository;

@SpringBootTest
class IOrderServiceImplTest {
	@InjectMocks
	IOrderServiceImpl os;
	@Mock
	IOrderRepository or;
	
	@Test
	void testFindAllOrders() {
		List<OrderDao> order=new ArrayList<>();
		System.out.println(os.findAllOrders());
		for(OrderDao o:os.findAllOrders()) {
			order.add(o);
		}
		assertNotNull(order);
	}

	@Test
	void testFindOrdersByUserId() {
		List<OrderDao> order=new ArrayList<>();
		for(OrderDao o:os.findOrdersByUserId("1001")) {
			order.add(o);
		}
		assertNotNull(order);
	}



}
