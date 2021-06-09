package com.greetotdoor.service;

import java.util.List;

import com.greetotdoor.dao.WishDao;
import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.exception.WishlistException;
import com.greetotdoor.pojos.WishlistRequest;

public interface IWishlistService {

	public List<WishDao> findAllItems();

	public List<WishDao> findWishlist(int userId);

	public WishDao findWishlistItem(String productId, String userId);
	public void addProductToWishlist(String prodId,int wishlistID);
	public void deleteWishlistItem(String productId, String userId) throws WishlistException;

	public void deleteWishlist(String userId) throws WishlistException;

	public WishlistitemEntity addWishlistItem(WishlistRequest wrequest) throws WishlistException;

}