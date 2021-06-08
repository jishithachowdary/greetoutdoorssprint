package com.greetotdoor.entities;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Product_Table")
public class ProductEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "pro_gen")
	@SequenceGenerator(name="pro_gen", sequenceName="s_product", allocationSize=1)
	@Column(name="PRODUCT_ID")
	private String productId;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="PRICE")
	double price;
	@Column(name="IMAGE")
	String image;
	@Column(name="COLOR")
	String colour;
	@Column(name="CATEGORY")
	String category;
	@Column(name="QUANTITY")
	int quantity;
	@Column(name="MANUFACTURE")
	String manufacturer;
	@Column(name="SPECIFICATION")
	String specification;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="product")
	private Set<WishlistitemEntity> wishlist=new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="CART_ID")
	private Set<CartItemEntity> cart;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="ORDER_ID")
	private Set<OrderEntity> order;
	
//	public CartItemEntity getCart() {
//		return cart;
//	}
//	public void setCart(CartItemEntity cart) {
//		this.cart = cart;
//	}
	public Set<WishlistitemEntity> getWishlist() {
		return wishlist;
	}
	public void setWishlist(Set<WishlistitemEntity> wishlist) {
		this.wishlist = wishlist;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
		
	public void addwishlist(WishlistitemEntity wishlist) {
		this.wishlist.add(wishlist);
	}
	public Set<CartItemEntity> getCart() {
		return cart;
	}
	public void setCart(Set<CartItemEntity> cart) {
		this.cart = cart;
	}
	
	public void addcart(CartItemEntity cartlist) {
		this.cart.add(cartlist);
	}
	public Set<OrderEntity> getOrder() {
		return order;
	}
	public void setOrder(Set<OrderEntity> order) {
		this.order = order;
	}
	public void addOrder(OrderEntity order) {
		this.order.add(order);
	}
	

}



