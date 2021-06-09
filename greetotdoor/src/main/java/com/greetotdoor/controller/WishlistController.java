package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.dao.WishDao;
import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.exception.WishlistException;
import com.greetotdoor.pojos.WishlistRequest;
import com.greetotdoor.service.IWishlistServiceImpl;

@RestController
public class WishlistController {
	@Autowired
	private IWishlistServiceImpl ws;
	
	@RequestMapping(method=RequestMethod.POST,value="/wishlist/insert")
	public WishlistitemEntity addWishlistItem(@RequestBody WishlistRequest wrequest) throws WishlistException {
		return ws.addWishlistItem(wrequest);
	}
	@RequestMapping("/wishlist")
	public List<WishDao> findAllItems(){
		return ws.findAllItems();
	}
	@RequestMapping("/wishlist/userid/{userid}")
	public List<WishDao> findWishlist(@PathVariable int userid){
		return ws.findWishlist(userid);
	}
	@RequestMapping("/wishlist/productid/{productId}/userid/{userId}")
	public WishDao findWishlistItem(@PathVariable String productId,@PathVariable  String userId) {
		return ws.findWishlistItem(productId, userId);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/wishlist/addproduct/{prodId}/id/{wishlistID}")
	public void addProductToWishlist(@PathVariable String prodId,@PathVariable int wishlistID) {
		ws.addProductToWishlist(prodId, wishlistID);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/wishlist/delete/{userId}")
	public void deleteWishlist(@PathVariable String userId) throws WishlistException{
		ws.deleteWishlist(userId);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/whishlist/delete/product/{productId}/userid/{userId}")
	public void deleteWishlistItem(@PathVariable String productId,@PathVariable String userId) throws WishlistException{
		ws.deleteWishlistItem(productId, userId);
	}

}
