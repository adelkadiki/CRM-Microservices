package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Sport;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.SportRepository;

@Service
public class SportService {

	@Autowired
	private SportRepository repository;
	
	
	public Sport add(Sport sport) {
		return repository.save(sport);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Sport findById(Long id) {
		
		return repository.findSportById(id);
	}
}
