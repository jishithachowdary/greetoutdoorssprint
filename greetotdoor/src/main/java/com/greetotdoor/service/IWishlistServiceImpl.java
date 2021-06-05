package com.greetotdoor.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.pojos.WishlistRequest;
import com.greetotdoor.repository.IProductRepository;
import com.greetotdoor.repository.IWishlistRepository;

@Service
public class IWishlistServiceImpl implements IWishlistService{
	@Autowired
	private IWishlistRepository wr;
	@Autowired
	IProductRepository pr;
	public WishlistitemEntity addWishlistItem(WishlistRequest wrequest) {
		WishlistitemEntity wl=new WishlistitemEntity();
			wl.setUserId(wrequest.userId);
			wl.setProduct(wrequest.product
					.stream().map(p->{
						ProductEntity pe=p;
						
							pe=pr.findByProductId(pe.getProductId());
						
						pe.addwishlist(wl);
						return pe;
					}).collect(Collectors.toSet()));
			 return wr.save(wl);
		}
}


