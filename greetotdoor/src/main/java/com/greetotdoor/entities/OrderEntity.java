package com.greetotdoor.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_TABLE")
public class OrderEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO,generator = "ord_gen")
//	@SequenceGenerator(name="ord_gen", sequenceName="s_order", allocationSize=1)
	@Column(name="ORDER_ID")
	private String orderId;
	@Column(name="USER_ID")
	private int userId;
	/*@Column(name="PRODUCT_ID")
	private String productId;*/
	@Column(name="TOTAL_PRICE")
	private double totalPrice;
	@Column(name="TOTAL_QUANTITY")
	private long totalQuantity;
	@Column(name="DISPATCH_DATE")
	private LocalDate dispatchDate;
	@Column(name="DELIVERY_DATE")
	private LocalDate deliveryDate;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="PRODUCT_ORDER_TABLE",
	joinColumns= {@JoinColumn(name="ORDER_ID")},
	inverseJoinColumns= {@JoinColumn(name="PRODUCT_ID")})
	@MapKey(name="productName")
	private Map<String,ProductEntity>  productOrder=new HashMap<String,ProductEntity>();
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Map<String, ProductEntity> getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(Map<String, ProductEntity> productOrder) {
		this.productOrder = productOrder;
	}
public void addProduct(ProductEntity product) {
		
		if(!getProductOrder().containsKey(product.getProductName())) {
			
			ProductEntity pe=product;
			getProductOrder().put(product.getProductName(), product);
			System.out.println(getProductOrder());
			
		}
		else {
			ProductEntity p=getProductOrder().get(product.getProductId());
			p.setQuantity(p.getQuantity()+product.getQuantity());
		}

	}
	
	
	
}
