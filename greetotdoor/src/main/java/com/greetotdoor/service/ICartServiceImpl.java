package com.greetotdoor.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;
import com.greetotdoor.repository.ICartRepository;
import com.greetotdoor.repository.IProductRepository;
import com.greetotdoor.repository.IUserRepository;

@Service
public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cr;
	@Autowired
	IProductRepository pr;
	@Autowired
	IUserRepository ur;
	public void addCart(CartRequest crequest) throws CartException{
		int totalquantity=0;
		double totalprice=0;
		CartItemEntity cart=new CartItemEntity();
		
		if(ur.findById(Integer.parseInt(crequest.userId)) != null) {
			cart.setUserId(crequest.userId);
			for(Map.Entry<String,ProductEntity> m:crequest.productCart.entrySet()) {
				ProductEntity pe=new ProductEntity();
				 pe=pr.findByProductId(m.getValue().getProductId());
				cart.addProduct(pe);
				pe.setQuantity(pe.getQuantity()-m.getValue().getQuantity());	
				pr.save(pe);
				totalquantity=totalquantity+m.getValue().getQuantity();
				totalprice=totalprice+(m.getValue().getQuantity()*(pe.getPrice()));
			}
			
			cart.setTotalQuantity(totalquantity);
		
			cart.setCartTotalPrice(totalprice);
			
			 cr.save(cart);
		}else {
			throw new CartException("no user withuser id so cart cannot be added");
		}
		
	}
}
