package com.greetotdoor.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="WishListitemEntity")
public class WishlistitemEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wishListId")
	private int wishListId;
	@Column(name="userId")
	private String userId;
	@Column(name="productIds")
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id",nullable=false)
	
	private List<String> productids;
	
	public int getWishListId() {
		return wishListId;
	}
	public void setWishListId(int wishListId) {
		this.wishListId = wishListId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getProductids() {
		return productids;
	}
	public void setProductids(List<String> productids) {
		this.productids = productids;
	}
	
	
	

}
