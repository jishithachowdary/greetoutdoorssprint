package com.greetotdoor.repository;

import java.util.List;

import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.exception.CartException;

public interface ICartRepository {
	public List<CartItemEntity> findCartlist(String userId);
	public CartItemEntity findCartItem(String productId, String userId);
	public CartItemEntity addCart(CartItemEntity cartItemEntity) throws CartException;

	public CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException;

	public void deleteCartItem(Long cartId,String productId) throws CartException;

	public void deleteCartlist(String userId) throws CartException;

}

