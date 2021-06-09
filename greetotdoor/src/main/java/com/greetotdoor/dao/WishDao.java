package com.greetotdoor.dao;

import java.util.List;

public class WishDao {
	private int wid;
	private int uid;
	private List<ProductDao> products;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public List<ProductDao> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDao> products) {
		this.products = products;
	}
	
	
}
