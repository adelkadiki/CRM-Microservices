package com.microservice.userinfo.model;

import java.io.Serializable;

public class UserResp implements Serializable{

	
	private static final long serialVersionUID = -4492593714273722488L;
	
	private String userId;
	private String name;
	private String username;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserResp(String userId, String name, String username) {
		
		this.userId = userId;
		this.name = name;
		this.username = username;
	}
	
	public UserResp() {}
	
	

}
