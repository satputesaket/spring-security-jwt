package com.example.demospringsecurityjwt.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;

	public JwtAuthenticationToken(String token) {
		super(null, null);
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
