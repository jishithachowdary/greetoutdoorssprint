package com.greetotdoor.dao;

import java.util.List;

public class WishDao {
	private int wid;
	private String uid;
	private List<ProductDao> products;
	public WishDao() {
		
	}
	public WishDao(int wid, String uid, List<ProductDao> products) {
		super();
		this.wid = wid;
		this.uid = uid;
		this.products = products;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public List<ProductDao> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDao> products) {
		this.products = products;
	}
	
	
}
