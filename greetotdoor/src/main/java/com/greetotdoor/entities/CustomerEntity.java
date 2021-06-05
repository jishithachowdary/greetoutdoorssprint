package com.greetotdoor.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int customer_id;		
	@Column(name="CUSTOMER_NAME")
	private String customer_name;
	@Column(name="MOBILE_NO")
	private String mobile_no;
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	private Set<AddressEntity> address;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private UserData user;
	//getters and setters
	
	public int getCustomer_id() {
		return customer_id;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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
		for(AddressEntity t:address) {
			t.setCustomer(this);
		
	}
	}
	public void addAddress(AddressEntity address) {
		this.address.add(address);
	}


}