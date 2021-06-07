package com.greetotdoor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.exception.WishlistException;
import com.greetotdoor.pojos.WishlistRequest;
import com.greetotdoor.repository.IProductRepository;
import com.greetotdoor.repository.IWishlistRepository;


@Service
public class IWishlistServiceImpl implements IWishlistService{
	@Autowired
	private IWishlistRepository wr;
	@Autowired
	IProductRepository pr;
	public List<WishlistitemEntity> findAllItems(){
		return wr.findAll();
	}
//	public List<WishlistitemEntity> findWishlist(String userId){
//		return wr.findWishlist(userId);
//	}
//	public WishlistitemEntity findWishlistItem(String productId, String userId) {
//		return wr.findWishlistItem(productId, userId);
//	}
//	public void addProductToWishlist(String prodId,int wishlistID) throws Exception{
//		WishlistitemEntity wl=wr.findById(wishlistID).orElseThrow(()->new Exception("wishlist not found"));
//		wl.addProduct(pr.getById(prodId));
//		
//	}
//	public void deleteWishlistItem(String productId, String userId) throws WishlistException{
//		
//	}
//	public void deleteWishlist(String userId) throws WishlistException{
//		wr.deleteWishlist(userId);
//	}
	public WishlistitemEntity addWishlistItem(WishlistRequest wrequest) throws WishlistException{
		WishlistitemEntity wl=new WishlistitemEntity();
			wl.setUserId(wrequest.userId);
			wl.setProduct(wrequest.product
					.stream()
					.map(p->{
						ProductEntity pe=p;
						if(pe.getProductId().length()>0) {
							pe=pr.findByProductId(pe.getProductId());
							try {
							if(pe.getProductId().length()==0) {
								throw new WishlistException("np product available");
							}
							}catch(Exception e) {
								System.out.println(e);
							}
						}
						pe.addwishlist(wl);
						return pe;
				
			}).collect(Collectors.toSet()));
					
			 return wr.save(wl);
		}
}


