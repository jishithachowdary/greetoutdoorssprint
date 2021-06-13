package com.greetotdoor.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.dao.OrderDao;
import com.greetotdoor.dao.ProductDao;
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
		if(ur.findByUserId(orequest.userId) != null) {
			order.setUserId(orequest.userId);
			for(Map.Entry<String, ProductEntity> m:orequest.productOrder.entrySet()) {
				ProductEntity pe=new ProductEntity();
				pe=pr.findByProductId(m.getValue().getProductId());
				order.addProduct(pe);
				pe.setQuantity(pe.getQuantity()-m.getValue().getQuantity());	
				pr.save(pe);
				totalquantity=totalquantity+m.getValue().getQuantity();
				totalprice=totalprice+(m.getValue().getQuantity()*(pe.getPrice()));
			}
			System.out.println(orequest.delivaryDate+""+orequest.dispatchDate);
			order.setDeliveryDate(orequest.delivaryDate);
			order.setDispatchDate(orequest.dispatchDate);
			System.out.println(order.getDeliveryDate());
			order.setTotalPrice(totalprice);
			order.setTotalQuantity(totalquantity);
			System.out.println(totalquantity);
			order.setOrderId(orequest.orderId);
			or.save(order);
			
		}else {
			throw new OrderException("no user with given user id");
		}
	}
	
	public List<OrderDao> findAllOrders(){
			// TODO Auto-generated method stub
		List<OrderDao> order=new ArrayList<>();
		for(OrderEntity o:or.findAll()) {
			OrderDao od=new OrderDao();
			od.setUid(o.getUserId());
			od.setOid(o.getOrderId());
			Map<String,ProductDao> p=new HashMap<>();
			for(Map.Entry<String,ProductEntity> pe:o.getProductOrder().entrySet()) {
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
				p.put(pd.getPname(), pd);		
				
				System.out.println(od);
				}
			od.setProductOrder(p);
			od.setTotalPrice(o.getTotalPrice());
			od.setTotalQuantity(o.getTotalQuantity());
			od.setDeliveryDate(o.getDeliveryDate());
			od.setDispatchDate(o.getDispatchDate());
			order.add(od);
			}
		return order;
				//return or.findOrderbyId(productId, userId);
	}
	public List<OrderDao> findOrdersByUserId(String userId) {
		// TODO Auto-generated method stub
		List<OrderDao> orderDao=new ArrayList<>();
		List<OrderEntity> oe=or.findAll();
		for(OrderEntity o:oe) {
			if(o.getUserId().equals(userId)) {
				OrderDao od=new OrderDao();
				od.setUid(o.getUserId());
				od.setOid(o.getOrderId());
					//
					Map<String,ProductDao> p=new HashMap<>();
					for(Map.Entry<String,ProductEntity> pe:o.getProductOrder().entrySet()) {
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
					od.setProductOrder(p);
					od.setTotalPrice(o.getTotalPrice());
					od.setTotalQuantity(o.getTotalQuantity());
					od.setDeliveryDate(o.getDeliveryDate());
					od.setDispatchDate(o.getDispatchDate());
					orderDao.add(od);
			}
		}
			return orderDao;		
		//return cr.findAll();
	}
	public void deleteOrderById(String orderId) throws OrderException {
		// TODO Auto-generated method stub
		OrderEntity o=or.findById(orderId).orElseThrow(()->new OrderException("order not found"));
		if(o.getProductOrder().size()>0) {
			Iterator<String> m=o.getProductOrder().keySet().iterator();
			while (m.hasNext()) {
				String  item=m.next();
				m.remove();
			}
			or.delete(o);
		}
	}
	
	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException{
		for(OrderEntity o:or.findAll()) {
			System.out.println("inside");
			System.out.println(o.getOrderId()+" "+orderId);
			if(o.getOrderId().equals(orderId)) {
				System.out.println("date");
				o.setDeliveryDate(arrivalDate);
				o.setDispatchDate(dispatchDate);
				or.save(o);
			}
		}
	}
	public void deleteAllOrders() throws OrderException{
		for(OrderEntity o:or.findAll()) {
			if(o.getProductOrder().size()>0) {
				Iterator<String> m=o.getProductOrder().keySet().iterator();
				while (m.hasNext()) {
					String  item=m.next();
					m.remove();
				}
			}
			or.delete(o);
		}
		
	}
}
