package com.microservice.gateway.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthorizationFilter extends BasicAuthenticationFilter{

	Environment env;
	
	public AuthorizationFilter(AuthenticationManager authManager, Environment env) {
		super(authManager);
		this.env=env;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
					throws IOException, ServletException{
		
		String authHeader = request.getHeader(env.getProperty("token.header.name"));
		if(authHeader==null || !authHeader.startsWith(env.getProperty("token.header.prefix"))) {
			chain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
		
		String authHeader= req.getHeader(env.getProperty("token.header.name"));
		if(authHeader==null) {
			return null;
		}
		
		String token = authHeader.replace(env.getProperty("token.header.prefix"), "");
		String userId = Jwts.parser()
				.setSigningKey(env.getProperty("token.secrete"))
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
		if(userId==null) {
			return null;
		}
		return new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
	}
	
}
