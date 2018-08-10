package com.example.demospringsecurityjwt.security;

import org.springframework.stereotype.Component;

import com.example.demospringsecurityjwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JwtUser jwtUser) {
		Claims claim = Jwts.claims().setSubject(jwtUser.getUsername());
		claim.put("userId", jwtUser.getId());
		claim.put("role", jwtUser.getRole());
		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, "1234").compact();

	}

}
