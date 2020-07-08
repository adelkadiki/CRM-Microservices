package com.microservice.userinfo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.microservice.userinfo.model.UserModel;
import com.microservice.userinfo.model.UserReq;
import com.microservice.userinfo.model.UserResp;

public interface UserService extends UserDetailsService{
	
	UserModel createUser(UserReq user);
	UserModel getUserDetailsByUsername(String username);
	List<UserModel> getAllUsers();
	UserModel findUserById(Long id);
	UserModel updateUser(UserModel user);
	void deleteById(Long id);
	
}
