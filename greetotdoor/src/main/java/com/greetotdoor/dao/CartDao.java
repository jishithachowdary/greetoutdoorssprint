package com.greetotdoor.dao;

import java.util.Map;

import com.greetotdoor.entities.ProductEntity;

public class CartDao {
	private int cartId;
	private String userId;
	private double cartTotalPrice;
	private int totalQuantity;
	private Map<String,ProductDao>  productCart;
	public CartDao() {
		
	}
	public CartDao(int cartId, String userId, double cartTotalPrice, int totalQuantity,
			Map<String, ProductDao> productCart) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
		this.productCart = productCart;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getCartTotalPrice() {
		return cartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Map<String, ProductDao> getProductCart() {
		return productCart;
	}
	public void setProductCart(Map<String, ProductDao> productCart) {
		this.productCart = productCart;
	}
	
}
