package com.greetotdoor.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SALESREPORT_TABLE")
public class SalesReport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Salesgenerator")
	@SequenceGenerator(name="Salesgenerator", sequenceName="S_sales", allocationSize=1)
	@Column(name="SALES_REPORT_ID")
	private int salesreportId;
	@Column(name="PRODUCT_ID")
	private String productId;
	@Column(name="QUANTITY_SOLD")
	private int quantitySold;
	@Column(name="TOTAL_SALE")
	private int totalSale;
	public int getSalesreportId() {
		return salesreportId;
	}
	public void setSalesreportId(int salesreportId) {
		this.salesreportId = salesreportId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public int getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}
}