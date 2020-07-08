package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Place;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.PlaceRepository;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepository repository;
	
	
	public Place add(Place place) {
		return repository.save(place);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Place findById(Long id) {
		
		return repository.findPlaceById(id);
	}
}
