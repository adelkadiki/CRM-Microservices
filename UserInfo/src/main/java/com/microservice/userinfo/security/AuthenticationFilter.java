package com.microservice.userinfo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.userinfo.model.LoginRequest;
import com.microservice.userinfo.model.UserModel;
import com.microservice.userinfo.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private UserService service;
	private Environment environment;
	
	AuthenticationFilter(UserService service, Environment environment, AuthenticationManager manager){
		this.service=service;
		this.environment=environment;
		super.setAuthenticationManager(manager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException{
		
		try {
			
			LoginRequest creds = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
					return getAuthenticationManager().authenticate(
							new UsernamePasswordAuthenticationToken(
									creds.getUsername(),
									creds.getPassword(),
									new ArrayList<>()
									)
							);
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
			FilterChain chain, Authentication auth)throws IOException, ServletException {
		String username = ((User) auth.getPrincipal()).getUsername();
		UserModel user = service.getUserDetailsByUsername(username);
		
		String token = Jwts.builder().setSubject(user.getUserId())
						.setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(environment.getProperty("token.expiration"))))
						.signWith(SignatureAlgorithm.HS512 , environment.getProperty("token.secrete")).compact();
						res.addHeader("token", token);
						res.addHeader("userID", user.getUserId());
	}

}
