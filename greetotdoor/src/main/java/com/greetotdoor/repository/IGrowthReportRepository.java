package com.greetotdoor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.GrowthReport;
import com.greetotdoor.exception.GrowthReportException;
import com.greetotdoor.exception.SalesReportException;

@Service
public interface IGrowthReportRepository extends JpaRepository<GrowthReport,Integer>{
//	 List<GrowthReport> findAllGrowthReport();
//
//	 void addGrowthReport() throws SalesReportException;
//
//	 void deleteAllGrowthReport() throws GrowthReportException;
//
//	 void deleteGrowthReportById(Long growthReportId) throws GrowthReportException;
}

