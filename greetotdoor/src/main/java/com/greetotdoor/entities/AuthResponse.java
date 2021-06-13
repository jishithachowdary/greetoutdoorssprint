package com.greetotdoor.entities;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class AuthResponse {
	private String token;
	private Collection<? extends GrantedAuthority> roles;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles2) {
		this.roles = roles2;
	}	
}