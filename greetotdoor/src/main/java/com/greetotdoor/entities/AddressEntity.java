package com.greetotdoor.entities;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADDRESS_TABLE")
public class AddressEntity implements Serializable{
	public static final long serialVersionUID = 901514215648120L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "add_gen")
	@SequenceGenerator(name="add_gen", sequenceName="s_customer", allocationSize=1)
	@Column(name="ADDRESS_ID")
	private int addressId;	
	@Column(name="BUILDING_NO")
	private int buildingNo;
	@Column(name="STREET_NAME")
	private String streetName;
	@Column(name="AREA")
	private String area;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="ZIP")
	private String zip;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	@JsonIgnore
	private CustomerEntity customer;
	
	public AddressEntity() {
		
	}
	public AddressEntity(int addressId,int buildingNo, String streetName, String area, String city, String state,
			String zip) {
		this.addressId=addressId;
		this.buildingNo = buildingNo;
		this.streetName = streetName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	//getters and setters
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	

	
}
	
	
	
	