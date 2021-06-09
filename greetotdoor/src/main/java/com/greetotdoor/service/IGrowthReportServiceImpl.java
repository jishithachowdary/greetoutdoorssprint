package com.greetotdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.GrowthReport;
import com.greetotdoor.exception.GrowthReportException;
import com.greetotdoor.repository.IGrowthReportRepository;

@Service
public class IGrowthReportServiceImpl implements IGrowthReportService{
	@Autowired
	IGrowthReportRepository gr;
	public List<GrowthReport> findAllGrowthReport(){
		return gr.findAll();
	}
	public void deleteAllGrowthReport() throws GrowthReportException{
		gr.deleteAll();
	}
	public void deleteGrowthReportById(int growthReportId) throws GrowthReportException{
		gr.deleteById(growthReportId);
	}
}
