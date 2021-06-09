package com.greetotdoor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.dao.ProductDao;
import com.greetotdoor.dao.WishDao;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.WishlistitemEntity;
import com.greetotdoor.exception.WishlistException;
import com.greetotdoor.pojos.WishlistRequest;
import com.greetotdoor.repository.IProductRepository;
import com.greetotdoor.repository.IUserRepository;
import com.greetotdoor.repository.IWishlistRepository;


@Service
public class IWishlistServiceImpl implements IWishlistService{
	@Autowired
	private IWishlistRepository wr;
	@Autowired
	IProductRepository pr;
	@Autowired
	IUserRepository ur;
	public List<WishDao> findAllItems(){
		List<WishlistitemEntity> wish=wr.findAll();
		List<WishDao> wishDao=new ArrayList<>();
		if(wish.size()>0) {
			
			for(WishlistitemEntity w:wish) {
				WishDao wd=new WishDao();
				wd.setUid(w.getUserId());
				wd.setWid(w.getWishListId());
				List<ProductDao> p=new ArrayList<>();
				for(ProductEntity pe:w.getProduct()) {
					ProductDao pd=new ProductDao();
					pd.setPid(pe.getProductId());
					pd.setPname(pe.getProductName());
					pd.setPrice(pe.getPrice());
					pd.setQuantity(pe.getQuantity());
					pd.setSpecification(pe.getSpecification());
					pd.setManufacturer(pe.getManufacturer());
					pd.setImage(pe.getImage());
					pd.setColour(pe.getColour());
					pd.setCategory(pe.getCategory());
					p.add(pd);
				
				}
				wd.setProducts(p);
				wishDao.add(wd);
			}
		}
		return wishDao;
		
	}
	public List<WishDao> findWishlist(int userId){
		List<WishDao> wishDao=new ArrayList<>();
		for(WishlistitemEntity w:wr.findAll()) {
			if(w.getUserId()==userId) {
					WishDao wd=new WishDao();
					wd.setUid(w.getUserId());
					wd.setWid(w.getWishListId());
					List<ProductDao> p=new ArrayList<>();
					for(ProductEntity pe:w.getProduct()) {
						ProductDao pd=new ProductDao();
						pd.setPid(pe.getProductId());
						pd.setPname(pe.getProductName());
						pd.setPrice(pe.getPrice());
						pd.setQuantity(pe.getQuantity());
						pd.setSpecification(pe.getSpecification());
						pd.setManufacturer(pe.getManufacturer());
						pd.setImage(pe.getImage());
						pd.setColour(pe.getColour());
						pd.setCategory(pe.getCategory());
						p.add(pd);
					
					}
					wd.setProducts(p);
					wishDao.add(wd);
			}
		}
			return wishDao;
	}
	public WishDao findWishlistItem(String productId, String userId) {
		WishDao wd=new WishDao();
		for(WishlistitemEntity w:wr.findAll()) {
			if(w.getUserId()==Integer.parseInt(userId)) {
					wd.setUid(w.getUserId());
					wd.setWid(w.getWishListId());
					List<ProductDao> p=new ArrayList<>();
					for(ProductEntity pe:w.getProduct()) {
						if(pe.getProductId().equals(productId)) {
						ProductDao pd=new ProductDao();
						pd.setPid(pe.getProductId());
						pd.setPname(pe.getProductName());
						pd.setPrice(pe.getPrice());
						pd.setQuantity(pe.getQuantity());
						pd.setSpecification(pe.getSpecification());
						pd.setManufacturer(pe.getManufacturer());
						pd.setImage(pe.getImage());
						pd.setColour(pe.getColour());
						pd.setCategory(pe.getCategory());
						p.add(pd);
						wd.setProducts(p);
						return wd;
					}
				}
					
			}
			
		}
		
		return new WishDao();
		
	}
	public void addProductToWishlist(String prodId,int wishlistID){
		System.out.println(wishlistID);
		for(WishlistitemEntity w:wr.findAll()) {
			
			if(w.getWishListId()==wishlistID) {
				ProductEntity pe=pr.findByProductId(prodId);
				w.addProduct(pe);
				wr.save(w);
				break;
			}
		}
		
	}
	public void deleteWishlistItem(String productId, String userId) throws WishlistException{
		for(WishlistitemEntity w:wr.findAll()) {
			if(w.getUserId()==Integer.parseInt(userId)) {
				System.out.println("user done");
				if(w.getProduct().size()==0) {
					throw new WishlistException("no products in this wish list");
				}
				else {
					for(ProductEntity pe:w.getProduct()) {
						System.out.println("product entry");
						if(pe.getProductId().equals(productId)) {
							System.out.println(pe.getProductId()+" "+productId);
							w.removeProduct(pe);
							
						}
					}
				}
				wr.save(w);
			}
		}
	}
	public void deleteWishlist(String userId) throws WishlistException{
		for(WishlistitemEntity w:wr.findAll()) {
			if(w.getUserId()==Integer.parseInt(userId)) {
					if(w.getProduct().size()==0) {
						wr.deleteById(w.getWishListId());
					}
					else {
						throw new WishlistException("failed to delted please deletd the products associated with this list");
					}
				
			}
		}
	}
	public WishlistitemEntity addWishlistItem(WishlistRequest wrequest) throws WishlistException{
		WishlistitemEntity wl=new WishlistitemEntity();
		if(ur.findById(wrequest.userId) != null) {
			wl.setUserId(wrequest.userId);
			wl.setProduct(wrequest.product
					.stream()
					.map(p->{
						ProductEntity pe=p;
						if(pe.getProductId().length()>0) {
							pe=pr.findByProductId(pe.getProductId());			
						}
						pe.addwishlist(wl);
						return pe;
				
			}).collect(Collectors.toSet()));
					
			 return wr.save(wl);
		}else {
			throw new WishlistException("user not present");
		}
		}
}


