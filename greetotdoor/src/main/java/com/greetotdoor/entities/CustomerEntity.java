package com.greetotdoor.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_TABLE")
public class CustomerEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "cus_gen")
	@SequenceGenerator(name="cus_gen", sequenceName="s_customer", allocationSize=1)
	@Column(name="CUSTOMER_ID")
	private int customerId;		
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="MOBILE_NO")
	private String mobileNo;
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<AddressEntity> address=new HashSet<>();
	public CustomerEntity() {
		
	}
	
	public CustomerEntity(int customerId,String customerName, String mobileNo, String email,
			Set<AddressEntity> address) {
		this.customerId=customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
	}
	//getters and setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(Set<AddressEntity> address) {
		this.address = address;
		for(AddressEntity a:address) {
			a.setCustomer(this);
		}
	}

	
	
	

}