package com.greetotdoor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.CartItemEntity;

@Service
public interface ICartRepository extends JpaRepository<CartItemEntity,Integer>{
//	 List<CartItemEntity> findCartlist(String userId);
//	 CartItemEntity findCartItem(String productId, String userId);

//	 CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException;
//
//	 void deleteCartItem(Long cartId,String productId) throws CartException;
//
//	 void deleteCartlist(String userId) throws CartException;

}

