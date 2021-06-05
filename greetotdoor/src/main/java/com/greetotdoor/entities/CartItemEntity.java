package com.greetotdoor.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CARTITEM_TABLE")
public class CartItemEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "cartitem_generator")
	@SequenceGenerator(name="cartitem_generator", sequenceName="S_CART", allocationSize=1)
	@Column(name="CART_ID")
	private int cartId;
	/*@Column(name="USER_ID")
	private String ;
	@Column(name="PRODUCT_ID")
	private String ;*/
	@Column(name="CARTTOTALPRICE")
	private double cartTotalPrice;
	@Column(name="TOTALQUANTITY")
	private int totalQuantity;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	
	
	
}
