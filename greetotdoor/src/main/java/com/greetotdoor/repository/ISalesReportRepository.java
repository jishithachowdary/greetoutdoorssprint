package com.greetotdoor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.SalesReport;

@Service
public interface ISalesReportRepository extends JpaRepository<SalesReport,Integer>{
	
}
