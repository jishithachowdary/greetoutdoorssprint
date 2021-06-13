package com.greetotdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.GrowthReport;
import com.greetotdoor.exception.GrowthReportException;
import com.greetotdoor.exception.SalesReportException;
import com.greetotdoor.service.IGrowthReportServiceImpl;

@RestController
public class GrowthReportController {
	@Autowired
	IGrowthReportServiceImpl gs;
	@RequestMapping("/growthreport/add")
	public void addGrowthReport() throws SalesReportException{
		gs.addGrowthReport();
	}
	@RequestMapping("/growthreport")
	public List<GrowthReport> findAllGrowthReport(){
		return gs.findAllGrowthReport();
	}
	@RequestMapping("/growthreport/delete")
	public void deleteAllGrowthReport() throws GrowthReportException{
		gs.deleteAllGrowthReport();
	}
	@RequestMapping("/growthreport/delete/{growthReportId}")
	public void deleteGrowthReportById(@PathVariable int growthReportId) throws GrowthReportException{
		gs.deleteGrowthReportById(growthReportId);
	}
}
