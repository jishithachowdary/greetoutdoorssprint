package com.greetotdoor.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "orderentity_generator")
	@SequenceGenerator(name="orderentity_generator", sequenceName="S_ORDER", allocationSize=1)
	@Column(name="ORDER_ID")
	private String orderId;
	/*@Column(name="USER_ID")
	private String userId;
	@Column(name="PRODUCT_ID")
	private String productId;*/
	@Column(name="TOTALPRICE")
	private double totalPrice;
	@Column(name="TOTALQUANTITY")
	private long totalQuantity;
	@Column(name="DISPATCH_DATE")
	private Date dispatchDate;
	@Column(name="DELIVERY_DATE")
	private Date deliveryDate;
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
	public Date getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
	
}
