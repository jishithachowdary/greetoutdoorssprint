package com.greetotdoor.repository;

import java.util.List;

import com.greetotdoor.entities.GrowthReport;
import com.greetotdoor.exception.GrowthReportException;
import com.greetotdoor.exception.SalesReportException;

public interface IGrowthReportRepository{
	 List<GrowthReport> findAllGrowthReport();

	 void addGrowthReport() throws SalesReportException;

	 void deleteAllGrowthReport() throws GrowthReportException;

	 void deleteGrowthReportById(Long growthReportId) throws GrowthReportException;
}

