package com.greetotdoor.service;

import java.util.List;
import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.pojos.WishlistRequest;

public interface IWishlistService {

//	public List<WishlistitemEntity> findAllItems();
//
//	public List<WishlistitemEntity> findWishlist(String userId);
//
//	public WishlistitemEntity findWishlistItem(String productId, String userId);
//	public void addProductToWishlist(String prodId,long wishlistID);
//	public void deleteWishlistItem(String productId, String userId) throws WishlistException;
//
//	public void deleteWishlist(String userId) throws WishlistException;

	public WishlistitemEntity addWishlistItem(WishlistRequest wrequest) ;

}