package com.greetotdoor.dao;

import java.util.List;
import java.util.Map;

public class OrderDao {
	private String oid;
	private int uid;
	private Map<String,ProductDao>  productOrder;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Map<String, ProductDao> getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(Map<String, ProductDao> productOrder) {
		this.productOrder = productOrder;
	}
	
	
	
}