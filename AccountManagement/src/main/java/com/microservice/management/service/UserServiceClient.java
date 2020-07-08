package com.microservice.management.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.microservice.management.model.UserModel;

import feign.FeignException;
import feign.hystrix.FallbackFactory;


@FeignClient(name="userinfo", fallbackFactory=UserinfoFallback.class)
public interface UserServiceClient {

	@GetMapping("/user/findall")
	public List<UserModel> getUsers();
	
	@GetMapping("/user/finduser/{id}")
	public UserModel findUserById(@PathVariable Long id);
	
	@PostMapping("/user/add")
	public UserModel addUser(@RequestBody UserModel user);
	
	@PutMapping("/user/update")
	public UserModel updateUser(@RequestBody UserModel user);
	
	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable Long id);
	
	
}

@Component
class UserinfoFallback implements FallbackFactory<UserServiceClient>{
	
	

	@Override
	public UserServiceClient create(Throwable cause) {
		
		return new UserinfoFallbackFactory(cause) ;
	}

	
}

class UserinfoFallbackFactory implements UserServiceClient{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final Throwable cause;
	
	public UserinfoFallbackFactory(Throwable cause) {
		this.cause=cause;
	}

	@Override
	public List<UserModel> getUsers() {
		
		if(cause instanceof FeignException && ((FeignException) cause).status()==404 ) {
			logger.error("404 error when calling Users list , Error message is "+cause.getMessage());
		}else {
			logger.error("Error ==="+cause.getMessage());
		}
		
		return new ArrayList<>();
	}

	@Override
	public UserModel findUserById(Long id) {
		
		if(cause instanceof FeignException && ((FeignException) cause).status()==404 ) {
			logger.error("404 error when try to find User with id = "+id+" Error message is "+cause.getMessage());
		}else {
			logger.error("Error ==="+cause.getMessage());
		}
		
		return new UserModel();
	}

	@Override
	public UserModel addUser(UserModel user) {
		
		if(cause instanceof FeignException && ((FeignException) cause).status()==404 ) {
			logger.error("404 error when adding User , Error message is "+cause.getMessage());
		}else {
			logger.error("Error ==="+cause.getMessage());
		}
		
		return new UserModel();
	}

	@Override
	public UserModel updateUser(UserModel user) {
		
		if(cause instanceof FeignException && ((FeignException) cause).status()==404 ) {
			logger.error("404 error when updating user , Error message is "+cause.getMessage());
		}else {
			logger.error("Error ==="+cause.getMessage());
		}
		return new UserModel();
	}

	@Override
	public void deleteUser(Long id) {
		if(cause instanceof FeignException && ((FeignException) cause).status()==404 ) {
			logger.error("404 error when deleting User with id =  "+id+" Error message is "+cause.getMessage());
		}else {
			logger.error("Error ==="+cause.getMessage());
		}
		
	}
	
}