package com.microservice.gateway.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private Environment env;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		.antMatchers(env.getProperty("api.zuul.actuator.url.path")).permitAll()
		.antMatchers(env.getProperty("api.users.actuator.url.path")).permitAll()
		.antMatchers(HttpMethod.POST,"/userinfo/user/register").permitAll()
		.antMatchers(HttpMethod.POST,"/userinfo/user/login").permitAll()
		.anyRequest().authenticated()
		.and().addFilter(new AuthorizationFilter(authenticationManager(), env)) ;
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
}
}