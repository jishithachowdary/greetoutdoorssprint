package com.greetotdoor.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User_Data")
public class UserData implements Serializable {
	private static final long serializableUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "u_gen")
	@SequenceGenerator(name="u_gen", sequenceName="s_user", allocationSize=1)
	@Column(name="userId")
	private int userId;
	@Column(name="userName")
	private String userName;
	
	@Column(name="userType")
	private String userType;
	@Column(name="userPassword")
	private String userPassword;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private CustomerEntity customer;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", userPassword="
				+ userPassword + ", customer=" + customer + "]";
	}
	
	
	
	
	
	

}
