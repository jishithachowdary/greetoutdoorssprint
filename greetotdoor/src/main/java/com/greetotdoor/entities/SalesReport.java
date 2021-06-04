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
	@Column(name="SALES_REPORT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Salesreport_id_generator")
	@SequenceGenerator(name="salesreport_id_generator", sequenceName="S_CUSTOMER", allocationSize=5)
	private int salesreportId;
	@Column(name="PRODUCT_ID")
	private String productId;
	@Column(name="PRODUCT_NAME")
	private String productName;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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