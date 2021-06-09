package com.greetotdoor.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.exception.WishlistException;



@Service
public interface IWishlistRepository extends JpaRepository<WishlistitemEntity,Integer>{
//	
//
//	@Query(name="WishlistitemEntity.getByUserId")
//	 List<WishlistitemEntity> findWishlist(String userId);
//	@Query(name="WishlistitemEntity.getByProductId")
//	 WishlistitemEntity findWishlistItem(String productId, String userId);

//	 void deleteWishlistItem(String productId, String userId) throws WishlistException;
//	@Query(name="WishlistitemEntity.deleteByUserId")
//	 void deleteWishlist(String userId) throws WishlistException;
	
}
