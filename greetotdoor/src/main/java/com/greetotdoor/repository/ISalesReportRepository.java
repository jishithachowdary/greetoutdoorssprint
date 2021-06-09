package com.greetotdoor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.SalesReport;

@Service
public interface ISalesReportRepository extends JpaRepository<SalesReport,Integer>{
//	 void updateProductReport(String productId,Integer quantity,double totalSale);
//	 boolean existsByProductId(String productId);
//	 SalesReport findByProductId(String productId);
}
