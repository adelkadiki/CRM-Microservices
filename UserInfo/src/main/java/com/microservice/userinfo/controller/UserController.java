package com.microservice.userinfo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userinfo.model.UserModel;
import com.microservice.userinfo.model.UserReq;
import com.microservice.userinfo.model.UserResp;
import com.microservice.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/check")
	public String check() {
		return "user webservice works fine, token is "+env.getProperty("token.secrete");
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAll(){
		
		return new ResponseEntity<>(service.getAllUsers() , HttpStatus.OK);
	}
	
	@GetMapping("/finduser/{id}")
	public UserModel findUser(@PathVariable(value="id") Long id) {
		return service.findUserById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<UserResp> createUser(@RequestBody UserReq userReq) {
		
		UserModel user= service.createUser(userReq);
		
		
		if(userReq==null) {
			return null;
		}
		ModelMapper maper = new ModelMapper();
		maper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResp userRes = maper.map(userReq, UserResp.class);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userRes); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user){
		
		UserModel userModel = service.findUserById(user.getId());
		user.setUserId(user.getUserId());
		
		 return new ResponseEntity<>(service.updateUser(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") Long id){
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
