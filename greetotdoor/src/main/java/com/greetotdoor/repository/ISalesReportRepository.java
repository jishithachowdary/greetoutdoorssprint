package com.greetotdoor.repository;

import com.greetotdoor.entities.SalesReport;

public interface ISalesReportRepository {
	 void updateProductReport(String productId,Integer quantity,double totalSale);
	 boolean existsByProductId(String productId);
	 SalesReport findByProductId(String productId);
}
