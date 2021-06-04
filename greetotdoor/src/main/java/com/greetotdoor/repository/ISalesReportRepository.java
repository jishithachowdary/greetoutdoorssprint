package com.greetotdoor.repository;

import com.greetotdoor.entities.SalesReport;

public interface ISalesReportRepository {
	public void updateProductReport(String productId,Integer quantity,double totalSale);
	public boolean existsByProductId(String productId);
	public SalesReport findByProductId(String productId);
}
