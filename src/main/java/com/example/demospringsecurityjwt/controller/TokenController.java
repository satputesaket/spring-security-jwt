package com.example.demospringsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringsecurityjwt.model.JwtUser;
import com.example.demospringsecurityjwt.security.JwtGenerator;

@RestController
public class TokenController {
	@Autowired
	JwtGenerator jwtGenerator;
	
	@PostMapping("/token/generate")
	public String generate(@RequestBody final JwtUser user) {
		return jwtGenerator.generate(user);
	}

}
