package com.greetotdoor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.dao.CartDao;
import com.greetotdoor.dao.ProductDao;
import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;
import com.greetotdoor.repository.ICartRepository;
import com.greetotdoor.repository.IProductRepository;
import com.greetotdoor.repository.IUserRepository;

@Service
public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cr;
	@Autowired
	IProductRepository pr;
	@Autowired
	IUserRepository ur;
	public void addCart(CartRequest crequest) throws CartException{
		int totalquantity=0;
		double totalprice=0;
		CartItemEntity cart=new CartItemEntity();
		
		if(ur.findById(crequest.userId) != null) {
			cart.setUserId(crequest.userId);
			for(Map.Entry<String,ProductEntity> m:crequest.productCart.entrySet()) {
				ProductEntity pe=new ProductEntity();
				 pe=pr.findByProductId(m.getValue().getProductId());
				cart.addProduct(pe);
				if(pe.getQuantity()>=m.getValue().getQuantity()) {
				pe.setQuantity(pe.getQuantity()-m.getValue().getQuantity());	
				pr.save(pe);
				totalquantity=totalquantity+m.getValue().getQuantity();
				totalprice=totalprice+(m.getValue().getQuantity()*(pe.getPrice()));
				}
				else {
					throw new CartException("product out of stock");
				}
			}
			
			cart.setTotalQuantity(totalquantity);
		
			cart.setCartTotalPrice(totalprice);
			
			 cr.save(cart);
		}else {
			throw new CartException("no user withuser id so cart cannot be added");
		}
	}
		
		public List<CartDao> findCartlist(String userId) {
			// TODO Auto-generated method stub
			List<CartDao> cartDao=new ArrayList<>();
			List<CartItemEntity> ce=cr.findAll();
			for(CartItemEntity c:ce) {
				if(c.getUserId()==Integer.parseInt(userId)) {
					CartDao cd=new CartDao();
					cd.setUserId(c.getUserId());
						cd.setCartId(c.getCartId());
						//
						Map<String,ProductDao> p=new HashMap<>();
						for(Map.Entry<String,ProductEntity> pe:c.getProductCart().entrySet()) {
							ProductDao pd=new ProductDao();
							pd.setPid(pe.getValue().getProductId());
							pd.setPname(pe.getValue().getProductName());
							pd.setPrice(pe.getValue().getPrice());
							pd.setQuantity(pe.getValue().getQuantity());
							pd.setSpecification(pe.getValue().getSpecification());
							pd.setManufacturer(pe.getValue().getManufacturer());
							pd.setImage(pe.getValue().getImage());
							pd.setColour(pe.getValue().getColour());
							pd.setCategory(pe.getValue().getCategory());
							//
							p.put(pd.getPname(), pd);
							
						
						}
						cd.setProductCart(p);
						cartDao.add(cd);
				}
			}
				return cartDao;
		
			//return cr.findAll();
		}

		public CartDao findCartItem(String productId, String userId) {
			// TODO Auto-generated method stub
			CartDao cd=new CartDao();
			for(CartItemEntity c:cr.findAll()) {
				if(c.getUserId()==Integer.parseInt(userId)) {
						cd.setUserId(c.getUserId());
						cd.setCartId(c.getCartId());
						//
						Map<String,ProductDao> p=new HashMap<>();
						for(Map.Entry<String,ProductEntity> pe:c.getProductCart().entrySet()) {
							//
							if(pe.getValue().getProductId().equals(productId)) {
							ProductDao pd=new ProductDao();
							pd.setPid(pe.getValue().getProductId());
							pd.setPname(pe.getValue().getProductName());
							pd.setPrice(pe.getValue().getPrice());
							pd.setQuantity(pe.getValue().getQuantity());
							pd.setSpecification(pe.getValue().getSpecification());
							pd.setManufacturer(pe.getValue().getManufacturer());
							pd.setImage(pe.getValue().getImage());
							pd.setColour(pe.getValue().getColour());
							pd.setCategory(pe.getValue().getCategory());
							//
							p.put(pd.getPname(), pd);
							cd.setProductCart(p);
							return cd;
							}
					}	
				}
			}
			
			return new CartDao();
			//return cr.findCartItem(productId, userId);
		}

		public CartItemEntity updateCart(CartRequest crequest) throws CartException {
			for(CartItemEntity c:cr.findAll()) {
				if(c.getCartId()==crequest.cartId) {
					int totalquantity=0;
					double totalprice=0;
					CartItemEntity cart=new CartItemEntity();
					cart.setCartId(crequest.cartId);
					cart.setUserId(crequest.userId);
					for(Map.Entry<String,ProductEntity> m:crequest.productCart.entrySet()) {
						ProductEntity pe=new ProductEntity();
						 pe=pr.findByProductId(m.getValue().getProductId());
						cart.addProduct(pe);
						if(pe.getQuantity()>=m.getValue().getQuantity()) {
						pe.setQuantity(pe.getQuantity()-m.getValue().getQuantity());	
						pr.save(pe);
						totalquantity=totalquantity+m.getValue().getQuantity();
						totalprice=totalprice+(m.getValue().getQuantity()*(pe.getPrice()));
						}
						else {
							throw new CartException("product out of stock");
						}
					}
					
					cart.setTotalQuantity(totalquantity);
				
					cart.setCartTotalPrice(totalprice);
					
					 cr.save(cart);
					 return cart;
				}
			}
			return new CartItemEntity();
		}
		
		
		public void deleteCartItem(Long cartId, String productId) throws CartException {
			// TODO Auto-generated method stub
			for(CartItemEntity c:cr.findAll()) {
				if(c.getCartId()==cartId) {
					if(c.getProductCart().size()==0) {
						throw new CartException("no products in this cart");
					}
					else {
						for(Map.Entry<String,ProductEntity> pe:c.getProductCart().entrySet()) {
							if(pe.getValue().getProductId().equals(productId)) {
								c.removeProductCart(pe.getKey());
							}
						}
					}
					//
					cr.save(c);
				}
			}
			//cr.deleteCartItem(cartId, productId);
		}
		public void deleteCartlist(String userId) throws CartException {
			// TODO Auto-generated method stub
			for(CartItemEntity c:cr.findAll()) {
				if(c.getUserId()==Integer.parseInt(userId)) {
						if(c.getProductCart().size()==0) {
							cr.deleteById(c.getCartId());
						}
						else {
							throw new CartException("failed to delete please delete the products associated with this list");
						}
					
				}
			}
			//cr.deleteCartlist(userId);
		}
	
	
		
	
}
