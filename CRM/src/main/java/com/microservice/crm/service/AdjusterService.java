package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.crm.model.Adjuster;
import com.microservice.crm.repository.AdjusterRepository;


@Service
public class AdjusterService {

	@Autowired
	private AdjusterRepository repository;
	
	
	public Adjuster add(Adjuster adjuster) {
		return repository.save(adjuster);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Adjuster findById(Long id) {
		
		return repository.findAdjusterById(id);
	}
	
	
}
