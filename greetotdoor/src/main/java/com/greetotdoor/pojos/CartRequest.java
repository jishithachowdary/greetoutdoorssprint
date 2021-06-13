package com.greetotdoor.pojos;

import java.util.Map;
import java.util.Set;

import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.UserData;

public class CartRequest {
	public int cartId;
	public String userId;
	public double cartTotalPrice;
	public int totalQuantity;
	public Map<String,ProductEntity>  productCart;
	public CartRequest() {
		
	}
	public CartRequest(int cartId, String userId, double cartTotalPrice, int totalQuantity,
			Map<String, ProductEntity> productCart) {
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
		this.productCart = productCart;
	}
	
}
