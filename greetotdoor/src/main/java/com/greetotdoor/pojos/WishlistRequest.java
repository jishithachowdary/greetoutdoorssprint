package com.greetotdoor.pojos;

import java.util.Set;

import com.greetotdoor.entities.ProductEntity;



public class WishlistRequest {
	public int wishListId;
	public String userId;
	public Set<ProductEntity> product;
}
