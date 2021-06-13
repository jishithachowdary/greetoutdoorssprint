package com.greetotdoor.pojos;

import java.time.LocalDate;
import java.util.Map;

import com.greetotdoor.entities.ProductEntity;

public class OrderRequest {
	public String orderId;
	public String userId;
	public double totalPrice;
	public LocalDate delivaryDate;
	public LocalDate dispatchDate;
	public Map<String,ProductEntity>  productOrder;
}
