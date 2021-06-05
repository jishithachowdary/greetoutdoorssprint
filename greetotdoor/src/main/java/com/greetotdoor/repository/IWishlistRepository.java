package com.greetotdoor.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.WishlistitemEntity;



@Service
public interface IWishlistRepository extends JpaRepository<WishlistitemEntity,Integer>{
	
//	 List<WishlistitemEntity> findAllItems();
//
//	 List<WishlistitemEntity> findWishlist(String userId);
//
//	 WishlistitemEntity findWishlistItem(String productId, String userId);
//	 void addProductToWishlist(String prodId,long wishlistID);
//	 void deleteWishlistItem(String productId, String userId) throws WishlistException;
//
//	 void deleteWishlist(String userId) throws WishlistException;

	

}
