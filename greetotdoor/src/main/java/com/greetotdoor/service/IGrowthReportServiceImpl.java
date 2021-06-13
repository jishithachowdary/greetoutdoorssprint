package com.greetotdoor.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.GrowthReport;
import com.greetotdoor.entities.OrderEntity;
import com.greetotdoor.entities.ProductEntity;
import com.greetotdoor.entities.SalesReport;
import com.greetotdoor.exception.GrowthReportException;
import com.greetotdoor.exception.SalesReportException;
import com.greetotdoor.repository.IGrowthReportRepository;
import com.greetotdoor.repository.IOrderRepository;
import com.greetotdoor.repository.IProductRepository;
import com.greetotdoor.repository.ISalesReportRepository;

@Service
public class IGrowthReportServiceImpl implements IGrowthReportService{
	@Autowired
	IGrowthReportRepository gr;
	@Autowired
	ISalesReportRepository sr;
	@Autowired
	IProductRepository pr;
	@Autowired
	IOrderRepository or;
	public void addGrowthReport() throws SalesReportException{
		GrowthReport g=new GrowthReport();
		int revenue=0;
		int amountChange=0;
		int percentageGrowth=0;
		if(gr.findAll().size()!=0) {
			GrowthReport gmax=gr.getMaxGrowthReportId();
			for(OrderEntity o:or.findAll()) {
				if(o.getDeliveryDate().isAfter(gmax.getCurrentdate()) && o.getDeliveryDate().isBefore(LocalDate.now())) {
					revenue=(int) o.getTotalPrice();
				}
			}
			g.setRevenue(revenue);
			amountChange=g.getRevenue()-gr.getMaxGrowthReportId().getRevenue();
			g.setAmountchange(amountChange);
			percentageGrowth=(g.getAmountchange()/g.getRevenue())*100;
			g.setPercentagegrowth(percentageGrowth);
			gr.save(g);
			
		}else {
			g.setAmountchange(amountChange);
			g.setPercentagegrowth(percentageGrowth);
			for(OrderEntity o:or.findAll()) {
				if(o.getDeliveryDate().isBefore(LocalDate.now())) {
					revenue=(int) o.getTotalPrice();
				}
			}
			g.setRevenue(revenue);
			g.setCurrentdate(LocalDate.now());
			gr.save(g);
		}
	}
	public List<GrowthReport> findAllGrowthReport(){
		return gr.findAll();
	}
	public void deleteAllGrowthReport() throws GrowthReportException{
		if(gr.findAll().size()!=0) {
			gr.deleteAll();
		}
		else {
			throw new GrowthReportException("no reports available for ");
		}
	}
	public void deleteGrowthReportById(int growthReportId) throws GrowthReportException{
		GrowthReport g=gr.findById(growthReportId).orElseThrow(()->new GrowthReportException("no growth report with the given growth id"));
		gr.deleteById(growthReportId);
	}
}
