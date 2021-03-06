package com.greetotdoor.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
	@Table(name="GROWTHREPORT_TABLE")
	public class GrowthReport implements Serializable {
		private static final long serialVersionUID = 1L;
		@Id
		@Column(name="GROWTH_REPORT_ID")
		@GeneratedValue(strategy=GenerationType.AUTO, generator="growthreport_id_generator")
		@SequenceGenerator(name="growthreport_id_generator", sequenceName="S_growth", allocationSize=1)
		private int growthreportId;
		@Column(name="CURRENT_DATE")
		private LocalDate currentdate;
	//	@ManyToOne(fetch=FetchType.LAZY)
		//@JoinColumn(name="PRODUCT_ID", nullable = false)
		@Column(name="REVENUE")
		private int revenue;
		@Column(name="AMOUNT_CHANGE")
		private int amountchange;
		@Column(name="PERCENTAGE_GROWTH")
		private int percentagegrowth;
		@Column(name="COLOR_CODE")
		private String colorcode;
		public int getGrowthreportId() {
			return growthreportId;
		}
		public void setGrowthreportId(int growthreportId) {
			this.growthreportId = growthreportId;
		}
		public LocalDate getCurrentdate() {
			return currentdate;
		}
		public void setCurrentdate(LocalDate localDate) {
			this.currentdate = localDate;
		}
		public int getRevenue() {
			return revenue;
		}
		public void setRevenue(int revenue) {
			this.revenue = revenue;
		}
		public int getAmountchange() {
			return amountchange;
		}
		public void setAmountchange(int amountchange) {
			this.amountchange = amountchange;
		}
		public int getPercentagegrowth() {
			return percentagegrowth;
		}
		public void setPercentagegrowth(int percentagegrowth) {
			this.percentagegrowth = percentagegrowth;
		}
		public String getColorcode() {
			return colorcode;
		}
		public void setColorcode(String colorcode) {
			this.colorcode = colorcode;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		}

