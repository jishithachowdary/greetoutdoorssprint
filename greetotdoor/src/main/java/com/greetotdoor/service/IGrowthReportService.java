package com.greetotdoor.service;

import java.util.List;

import com.greetotdoor.entities.GrowthReport;
import com.greetotdoor.exception.GrowthReportException;
import com.greetotdoor.exception.SalesReportException;

public interface IGrowthReportService {

	public List<GrowthReport> findAllGrowthReport();

	public void addGrowthReport() throws SalesReportException;

	public void deleteAllGrowthReport() throws GrowthReportException;

	public void deleteGrowthReportById(Long growthReportId) throws GrowthReportException;
}
