package com.example.demospringsecurityjwt.security;

import org.springframework.stereotype.Component;

import com.example.demospringsecurityjwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret="1234";
	public JwtUser validate(String token) {
		
		JwtUser jwtUser =null;
		try {
			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			jwtUser = new JwtUser();
			jwtUser.setUsername(claims.getSubject());
			jwtUser.setId(Long.valueOf((String)claims.getId()));
			jwtUser.setRole((String)claims.get("role"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jwtUser;

	}

}
