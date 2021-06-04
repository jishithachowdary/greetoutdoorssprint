package com.greetotdoor.repository;

import java.util.List;

import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.exception.CartException;

public interface ICartRepository {
	 List<CartItemEntity> findCartlist(String userId);
	 CartItemEntity findCartItem(String productId, String userId);
	 CartItemEntity addCart(CartItemEntity cartItemEntity) throws CartException;

	 CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException;

	 void deleteCartItem(Long cartId,String productId) throws CartException;

	 void deleteCartlist(String userId) throws CartException;

}

