package com.microservice.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.microservice.management.model.UserModel;
import com.microservice.management.service.UserServiceClient;

@RestController
@RequestMapping("/mng")
public class ManagementController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserServiceClient userService;
	
	@GetMapping("/status")
	public String status() {
		return "management works";
	}
	
	
	@GetMapping("/allusers")
	public List<UserModel> getUsers(){
//		
//		String url = "http://USERINFO/user/findall";
//		ResponseEntity<List<UserModel>> users = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserModel>>() {});
//		List<UserModel> usersList = users.getBody();
//		return usersList;
		
		List<UserModel> users= userService.getUsers();
		return users;
	}
	
	@GetMapping("finduser/{id}")
	public UserModel findUser(@PathVariable(value="id") Long id) {
		
//		String url = "http://USERINFO/user/finduser/"+id;
//		UserModel user= restTemplate.getForObject(url, UserModel.class);
		UserModel user= userService.findUserById(id);
		return user;
	}
	
	@PostMapping("/adduser")
	public UserModel addUser(@RequestBody UserModel user) {
//		String url = "http://USERINFO/user/add";
//		restTemplate.postForObject(url, user, UserModel.class );
		UserModel newuser= userService.addUser(user);
		return newuser;
	}
	
	@PutMapping("/update")
	public UserModel updateUser(@RequestBody UserModel user) {
//		String url = "http://USERINFO/user/update";
//		restTemplate.put(url, user);
		UserModel updateUser =userService.updateUser(user);
		return updateUser;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") Long id){
		
//		String url = "http://USERINFO/user/delete/"+id;
//		restTemplate.delete(url);
		userService.deleteUser(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
