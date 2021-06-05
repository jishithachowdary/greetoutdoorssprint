package com.greetotdoor.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="WHISHLISTITEM_TABLE")
public class WishlistitemEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "wish_gen")
	@SequenceGenerator(name="wish_gen", sequenceName="S_WHISHLIST", allocationSize=1)
	@Column(name="WHISHLIST_IS")
	private int wishListId;
	@Column(name="USER_ID")
	private String userId;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="PRODUCT_WHISHLIST_TABLE",
	joinColumns= {@JoinColumn(name="WHISHLIST_IS")},inverseJoinColumns= {@JoinColumn(name="PRODUCT_ID")})
	@JsonIgnore
	private Set<ProductEntity> product =new HashSet<>();
	public Set<ProductEntity> getProduct() {
		return product;
	}
	public void setProduct(Set<ProductEntity> product) {
		this.product = product;
	}
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
	public void addProduct(ProductEntity product) {
		this.product.add(product);
	}
	
	
	
	
	

}
