package com.microservice.userinfo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.microservice.userinfo.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	Environment environment;
	BCryptPasswordEncoder encoder;
	UserService service;
	
	@Autowired
	public WebSecurity(Environment environment, BCryptPasswordEncoder encoder, UserService service) {
		this.environment=environment;
		this.encoder=encoder;
		this.service=service;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("ip.gateway"))
		.and()
		.addFilter(getAuthenticationFilter());
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter filter = new AuthenticationFilter(service, environment, authenticationManager());
		//filter.setAuthenticationManager(authenticationManager());
		filter.setFilterProcessesUrl("/user/login");
		return filter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

}
