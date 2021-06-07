package com.greetotdoor.pojos;

import java.util.Map;
import java.util.Set;

import com.greetotdoor.entities.ProductEntity;

public class CartRequest {
	public int cartId;
	public String userId;
	public double cartTotalPrice;
	public int totalQuantity;
//	public Map<ProductEntity, Integer>  productCart;
	public Set<ProductEntity> pc;
}
