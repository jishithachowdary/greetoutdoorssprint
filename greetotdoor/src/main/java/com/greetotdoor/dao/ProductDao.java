package com.greetotdoor.dao;

import javax.persistence.Column;

public class ProductDao {
	private String pid;
	private String pname;
	private double price;
	private String image;
	private String colour;
	private String category;
	private int quantity;
	private String manufacturer;
	private String specification;
	public ProductDao() {
		
	}
	
	public ProductDao(String pid, String pname, double price, String image, String colour, String category,
			int quantity, String manufacturer, String specification) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.image = image;
		this.colour = colour;
		this.category = category;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
		this.specification = specification;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
}
