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
		sr.deleteById(salesReportId);
	}
	public void deleteAllSalesReport() throws SalesReportException{
		sr.deleteAll();
	}
	public void updateProductReport(SalesReport salesReportEntity) {
		sr.save(salesReportEntity);
	}
}
