package com.greetotdoor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.greetotdoor.dao.WishDao;
import com.greetotdoor.repository.IWishlistRepository;

@SpringBootTest
class IWishlistServiceImplTest {
	@InjectMocks
	IWishlistServiceImpl ws;
	@Mock
	IWishlistRepository wr;
	@Test
	void testFindAllItems() {
		List<WishDao> w =new ArrayList<>();
		for(WishDao wish:ws.findAllItems()) {
			w.add(wish);
		}
		assertNotNull(w);
	}

	@Test
	void testFindWishlist() {
		List<WishDao> w=new ArrayList<>();
		for(WishDao wish:ws.findWishlist("jishitha")) {
			w.add(wish);
		}
		assertNotNull(w);
	}

	@Test
	void testFindWishlistItem() {
		WishDao wd=ws.findWishlistItem("1001","1001");
		assertNotNull(wd);
	}

}
