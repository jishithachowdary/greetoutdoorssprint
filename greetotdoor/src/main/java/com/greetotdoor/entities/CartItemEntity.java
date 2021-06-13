package com.greetotdoor.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="USER_ID")
	private String userId;
	@Column(name="CART_TOTAL_PRICE")
	private double cartTotalPrice;
	@Column(name="TOTAL_QUANTITY")
	private int totalQuantity;
	
	
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="PRODUCT_CART_TABLE",
	joinColumns= {@JoinColumn(name="CART_ID")},
	inverseJoinColumns= {@JoinColumn(name="PRODUCT_ID")})
	@JsonIgnore
	@MapKey(name="productName")
	private Map<String,ProductEntity>  productCart=new HashMap<String,ProductEntity>();
	public CartItemEntity() {
		
	}
	public CartItemEntity(int cartId, String userId, double cartTotalPrice, int totalQuantity,
			Map<String, ProductEntity> productCart) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
		this.productCart = productCart;
	}
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

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Map<String,ProductEntity> getProductCart() {
		return productCart;
	}
	public void setProductCart(Map<String,ProductEntity> productCart) {
		this.productCart = productCart;
	}
	public void addProduct(ProductEntity product) {
		
		if(!getProductCart().containsKey(product.getProductName())) {
			
			ProductEntity pe=product;
			getProductCart().put(product.getProductName(), product);
			System.out.println(getProductCart());
			
		}
		else {
			ProductEntity p=getProductCart().get(product.getProductId());
			p.setQuantity(p.getQuantity()+product.getQuantity());
		}

	}
	
	public void removeProductCart(String pname) {
		this.productCart.remove(pname);
	}
	

}
