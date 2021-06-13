package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.SalesReport;
import com.greetotdoor.exception.SalesReportException;
import com.greetotdoor.service.ISalesReportServiceImpl;

@RestController
public class SalesReportCotroller {
	@Autowired
	ISalesReportServiceImpl service;
	@RequestMapping("/sales")
	public List<SalesReport> findAllSalesReport(){
		return service.findAllSalesReport();
	}
	@RequestMapping("/sales/{productId}")
	public SalesReport findSalesReportByProductId(@PathVariable String productId) {
		return service.findSalesReportByProductId(productId);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/sales/delete/{salesReportId}")
	public void deleteSalesReportById(@PathVariable int salesReportId) throws SalesReportException{
		service.deleteSalesReportById(salesReportId);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/sales/delete")
	public void deleteAllSalesReport() throws SalesReportException {
		service.deleteAllSalesReport();
	}
	@RequestMapping(method=RequestMethod.PUT,value="/sales/update")
	public void updateProductReport(@RequestBody SalesReport salesReportEntity) throws SalesReportException{
		service.updateProductReport(salesReportEntity);
	}
	@RequestMapping(method=RequestMethod.POST,value="/sales/insert")
	public void addSalesReport(@RequestBody SalesReport salesReportEntity) {
		service.addSalesReport(salesReportEntity);
	}
}
