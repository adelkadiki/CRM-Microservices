package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Spouse;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.SpouseRepository;

@Service
public class SpouseService {

	@Autowired
	private SpouseRepository repository;
	
	
	public Spouse add(Spouse spouse) {
		return repository.save(spouse);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Spouse findById(Long id) {
		
		return repository.findSpouseById(id);
	}
}
