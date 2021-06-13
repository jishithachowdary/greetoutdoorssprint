package com.greetotdoor.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greetotdoor.entities.UserData;


public class CustomUserBean implements UserDetails {
	private static final long serialVersionUID = -4709084843450077569L;	
	private String userName; 
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	CustomUserBean(String userName, 
			String password, Collection<? extends GrantedAuthority> authorities){
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static CustomUserBean createInstance(UserData user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
            authorities.add(new SimpleGrantedAuthority(user.getUserType()));
        
		return new CustomUserBean(user.getUserId(), 
				 user.getUserPassword(), authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object rhs) {
		if (rhs instanceof CustomUserBean) {
			return userName.equals(((CustomUserBean) rhs).userName);
		}
		return false;
	}

	/**
	 * Returns the hashcode of the {@code username}.
	 */
	@Override
	public int hashCode() {
		return userName.hashCode();
	}
}
