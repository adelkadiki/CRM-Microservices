package com.microservice.userinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.userinfo.model.UserModel;
import com.microservice.userinfo.model.UserReq;
import com.microservice.userinfo.model.UserResp;
import com.microservice.userinfo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImp implements UserService {

	UserRepository repository;
	BCryptPasswordEncoder encoder;
	
	@Autowired
	public UserServiceImp(UserRepository repository, BCryptPasswordEncoder encoder) {
		this.repository=repository;
		this.encoder=encoder;
	}
	
	
	@Override
	public UserModel createUser(UserReq userReq) {
		
		//Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
		userReq.setUserId(UUID.randomUUID().toString());
		userReq.setPassword(encoder.encode(userReq.getPassword()));

		//logger.info("userReq ========="+userReq);
		
		ModelMapper maper = new ModelMapper();
		maper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserModel user = maper.map(userReq, UserModel.class);
	//	logger.info("user after mapping =========="+user);
		repository.save(user);
		return user;
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel user= repository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, new ArrayList<>()) ;
	}


	@Override
	public UserModel getUserDetailsByUsername(String username) {
		
		UserModel user = repository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}


	@Override
	public List<UserModel> getAllUsers() {
		
		return repository.findAll();
		
	}


	@Override
	public UserModel findUserById(Long id) {
		
	return	repository.findUserById(id);
		
	}


	@Override
	public UserModel updateUser(UserModel user) {
		
		return repository.save(user);
		
	}


	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

}
