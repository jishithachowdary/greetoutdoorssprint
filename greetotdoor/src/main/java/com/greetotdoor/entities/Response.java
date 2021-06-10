package com.greetotdoor.entities;

public class Response {
	public final String jwt;

	public Response(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
}
