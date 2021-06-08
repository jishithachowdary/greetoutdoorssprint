package com.greetotdoor.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.exception.OrderException;
import com.greetotdoor.pojos.OrderRequest;
import com.greetotdoor.repository.IOrderRepository;
import com.greetotdoor.repository.IProductRepository;
import com.greetotdoor.repository.IUserRepository;

@Service
public class IOrderServiceImpl implements IOrderService{
	@Autowired
	IOrderRepository or;
	@Autowired
	IProductRepository pr;
	@Autowired
	IUserRepository ur;
	public void addOrder(OrderRequest orequest) throws OrderException{
		int totalquantity=0;
		double totalprice=0;
		OrderEntity order=new OrderEntity();
		if(ur.findById(orequest.userId) != null) {
			System.out.println("before user");
			order.setUserId(orequest.userId);
			System.out.println("after userid");
			for(Map.Entry<String, ProductEntity> m:orequest.productOrder.entrySet()) {
				ProductEntity pe=new ProductEntity();
				pe=pr.findByProductId(m.getValue().getProductId());
				order.addProduct(pe);
				pe.setQuantity(pe.getQuantity()-m.getValue().getQuantity());	
				pr.save(pe);
				totalquantity=totalquantity+m.getValue().getQuantity();
				totalprice=totalprice+(m.getValue().getQuantity()*(pe.getPrice()));
			}
			order.setDeliveryDate(orequest.deivaryDate);
			order.setDispatchDate(orequest.dispatchDate);
			order.setTotalPrice(totalprice);
			order.setTotalQuantity(totalquantity);
			System.out.println(totalquantity);
			order.setOrderId(orequest.orderId);
			or.save(order);
			
		}else {
			throw new OrderException("no user with given user id");
		}
	}
}
