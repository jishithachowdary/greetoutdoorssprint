package com.greetotdoor.repository;

import java.util.List;

import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.exception.WishlistException;

public interface IWishlistRepository{
	 List<WishlistitemEntity> findAllItems();

	 List<WishlistitemEntity> findWishlist(String userId);

	 WishlistitemEntity findWishlistItem(String productId, String userId);
	 void addProductToWishlist(String prodId,long wishlistID);
	 void deleteWishlistItem(String productId, String userId) throws WishlistException;

	 void deleteWishlist(String userId) throws WishlistException;

	 WishlistitemEntity addWishlistItem(WishlistitemEntity wishlistItem) throws WishlistException;

}
