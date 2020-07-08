package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Flooring;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.FlooringRepository;

@Service
public class FlooringService {

	@Autowired
	private FlooringRepository repository;
	
	
	public Flooring add(Flooring flooring) {
		return repository.save(flooring);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Flooring findById(Long id) {
		
		return repository.findFlooringById(id);
	}
}
