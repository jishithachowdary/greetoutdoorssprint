package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.dao.CartDao;
import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;
import com.greetotdoor.service.ICartServiceImpl;


@RestController
public class CartController {
	@Autowired
	private ICartServiceImpl cs;
	
	@RequestMapping(method=RequestMethod.POST,value="/cart/insert")
	public void addCart(@RequestBody CartRequest crequest) throws CartException {
		 cs.addCart(crequest);
	}
	@RequestMapping("/cart/userid/{userid}")
	public List<CartDao> findWishlist(@PathVariable String userid){
		return cs.findCartlist(userid);
	}
	@RequestMapping("/cart/productid/{productId}/userid/{userId}")
	public CartDao findCartItem(@PathVariable String productId,@PathVariable  String userId) {
		return cs.findCartItem(productId, userId);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/cart/delete/product/{productId}/cartId/{cartId}")
	public void deleteCartItem(@PathVariable String productId,@PathVariable long cartId) throws CartException{
		cs.deleteCartItem(cartId, productId);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/cart/delete/{userId}")
	public void deleteWishlist(@PathVariable String userId) throws CartException{
		cs.deleteCartlist(userId);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/cart/update")
	public CartItemEntity updateCart(@RequestBody CartRequest crequest) throws CartException{
		return cs.updateCart(crequest);
	}

}
