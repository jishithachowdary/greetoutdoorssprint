package com.greetotdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.SalesReport;
import com.greetotdoor.exception.SalesReportException;
import com.greetotdoor.repository.ISalesReportRepository;

@Service
public class ISalesReportServiceImpl implements ISalesReportService{
	@Autowired
	ISalesReportRepository sr;
	public List<SalesReport> findAllSalesReport(){
		System.out.println("in");
		return sr.findAll();
	}
	public SalesReport findSalesReportByProductId(String productId) {
		for(SalesReport s:sr.findAll()) {
			if(s.getProductId().equals(productId)) {
				return s;
			}
		}
		return null;
	}
	public void deleteSalesReportById(int salesReportId) throws SalesReportException{
		SalesReport sales=sr.findById(salesReportId).orElseThrow(()->new SalesReportException("there is no record with given sales report id"));
		sr.deleteById(salesReportId);
	}
	public void deleteAllSalesReport() throws SalesReportException{
		if(sr.findAll().size()!=0) {
		sr.deleteAll();
		}
		else {
			throw new SalesReportException("there are no records of sales report ");
		}
	}
	public void updateProductReport(SalesReport salesReportEntity) throws SalesReportException {
		SalesReport s=sr.findById(salesReportEntity.getSalesreportId()).orElseThrow(()->new SalesReportException("to update sales report there is no salesreport that mathches the given report "));
		if(salesReportEntity.getTotalSale()!=0) {
			s.setTotalSale(salesReportEntity.getTotalSale());
		}
		if(salesReportEntity.getQuantitySold()!=0) {
			s.setQuantitySold(salesReportEntity.getQuantitySold());
		}
		if(salesReportEntity.getProductId()!=null) {
			s.setProductId(salesReportEntity.getProductId());
		}
		sr.save(salesReportEntity);
	}
	public void addSalesReport(SalesReport salesReportEntity) {
		sr.save(salesReportEntity);
	}
	
}
