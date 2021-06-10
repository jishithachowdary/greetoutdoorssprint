package com.greetotdoor.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_TABLE")
public class UserData implements Serializable {
	private static final long serializableUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "u_gen")
	@SequenceGenerator(name="u_gen", sequenceName="s_user", allocationSize=1)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME",unique=true)
	private String username;
	
	@Column(name="USER_TYPE")
	private String userType;
	@Column(name="USER_PASSWORD")
	private String userPassword;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public static long getSerializableuid() {
		return serializableUID;
	}
	

	

	
	
	
	
	
	

}
