package com.greetotdoor.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderDao {
	private String oid;
	private String uid;
	private long totalQuantity;
	private double totalPrice;
	private LocalDate deliveryDate;
	private LocalDate dispatchDate;
	private Map<String,ProductDao>  productOrder;
	public OrderDao(){
		
	}
	public OrderDao(String oid, String uid, Map<String, ProductDao> productOrder) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.productOrder = productOrder;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Map<String, ProductDao> getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(Map<String, ProductDao> productOrder) {
		this.productOrder = productOrder;
	}
	
	
	
}