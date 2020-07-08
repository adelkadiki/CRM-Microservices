package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Kid;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.KidRepository;

@Service
public class KidService {

	
	@Autowired
	private KidRepository repository;
	
	
	public Kid add(Kid kid) {
		return repository.save(kid);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Kid findById(Long id) {
		
		return repository.findKidById(id);
	}
}
