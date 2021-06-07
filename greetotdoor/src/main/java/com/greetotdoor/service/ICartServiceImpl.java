package com.greetotdoor.service;

import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;
import com.greetotdoor.repository.ICartRepository;
import com.greetotdoor.repository.IProductRepository;

@Service
public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cr;
	@Autowired
	IProductRepository pr;
	public CartItemEntity addCart(CartRequest crequest) throws CartException{
		int totalquantity=0;
		double totalprice=0;
		CartItemEntity cart=new CartItemEntity();
		cart.setUserId(crequest.userId);
//		cart.setProductCart(crequest.productCart);
//		for(Entry<ProductEntity, Integer> m:crequest.productCart.entrySet()) {
//			ProductEntity pe=m.getKey();
//			totalquantity=m.getValue()+totalquantity;
//			pe=pr.findByProductId(pe.getProductId());
//			try {
//				if(pe.getProductId().length()==0) {
//					throw new CartException("no product available");
//				}
//				}catch(Exception e) {
//					System.out.println(e);
//				}
//			totalprice=(totalprice+m.getValue()*pe.getPrice());
//			pe.addcart(cart);
//		}
//		cart.setTotalQuantity(totalquantity);
//		cart.setCartTotalPrice(totalprice);
		return cr.save(cart);
	}
}
