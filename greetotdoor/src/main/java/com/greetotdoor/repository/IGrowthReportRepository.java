package com.greetotdoor.repository;

import java.util.List;

import com.greetotdoor.entities.GrowthReport;
import com.greetotdoor.exception.GrowthReportException;
import com.greetotdoor.exception.SalesReportException;

public interface IGrowthReportRepository{
	public List<GrowthReport> findAllGrowthReport();

	public void addGrowthReport() throws SalesReportException;

	public void deleteAllGrowthReport() throws GrowthReportException;

	public void deleteGrowthReportById(Long growthReportId) throws GrowthReportException;
}

