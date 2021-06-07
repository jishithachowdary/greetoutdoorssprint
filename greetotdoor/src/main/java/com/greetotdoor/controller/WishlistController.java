package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public List<WishlistitemEntity> findAllItems(){
		return ws.findAllItems();
	}
//	@RequestMapping("/wishlist/userid/{userid}")
//	public List<WishlistitemEntity> findWishlist(String userId){
//		return ws.findWishlist(userId);
//	}

}
