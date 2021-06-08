package com.greetotdoor.pojos;

import java.time.LocalDate;
import java.util.Map;

import com.greetotdoor.entities.ProductEntity;

public class OrderRequest {
	public String orderId;
	public int userId;
	public double totalPrice;
	public LocalDate dispatchDate;
	public LocalDate deivaryDate;
	public Map<String,ProductEntity>  productOrder;
}
