package com.example.demospringsecurityjwt.security;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demospringsecurityjwt.model.JwtAuthenticationToken;
import com.example.demospringsecurityjwt.model.JwtUser;
import com.example.demospringsecurityjwt.model.JwtUserDetails;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	// main authentication process class.

	private JwtValidator jwtValidator;

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return (JwtAuthenticationToken.class.isAssignableFrom(arg0));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String arg0, UsernamePasswordAuthenticationToken userToken)
			throws AuthenticationException {
		JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) userToken;
		String token = jwtToken.getToken();
		JwtUser jwtUser = (JwtUser) jwtValidator.validate(token);
		if (null == jwtUser) {
			throw new RuntimeException("Jwt token incorrect.");
		}
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		JwtUserDetails jwtUserDetails = new JwtUserDetails();
		jwtUserDetails.setUsername(jwtUser.getUsername());
		jwtUserDetails.setToken(token);
		jwtUserDetails.setId(jwtUser.getId());
		jwtUserDetails.setAuthorities(grantedAuthorities);
		return jwtUserDetails;
	}

}
