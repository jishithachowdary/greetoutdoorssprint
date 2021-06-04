package com.greetotdoor.service;

import java.util.List;

import com.greetotdoor.entities.SalesReport;
import com.greetotdoor.exception.SalesReportException;

public interface ISalesReportService {

	public List<SalesReport> findAllSalesReport();

	public SalesReport findSalesReportByProductId(String productId);

	public void updateProductReport(SalesReport salesReportEntity);

	public void deleteAllSalesReport() throws SalesReportException;

	public void deleteSalesReportById(Long salesReportId) throws SalesReportException;

}

