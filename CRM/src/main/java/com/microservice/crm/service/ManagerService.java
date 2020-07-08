package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Manager;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository repository;
	
	
	public Manager add(Manager manager) {
		return repository.save(manager);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Manager findById(Long id) {
		
		return repository.findManagerById(id);
	}
}
