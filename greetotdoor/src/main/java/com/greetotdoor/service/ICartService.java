package com.greetotdoor.service;

import java.util.List;

import com.greetotdoor.dao.CartDao;
import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;

public interface ICartService {
	public List<CartDao> findCartlist(String userId);
	public CartDao findCartItem(String productId, String userId);
	public void addCart(CartRequest crequest) throws CartException;

	public CartItemEntity updateCart(CartRequest crequest) throws CartException;

	public void deleteCartItem(Long cartId,String productId) throws CartException;

	public void deleteCartlist(String userId) throws CartException;
}
