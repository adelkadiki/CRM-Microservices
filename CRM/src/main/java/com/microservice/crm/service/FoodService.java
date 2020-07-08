package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Food;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repository;
	
	
	public Food add(Food food) {
		return repository.save(food);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Food findById(Long id) {
		
		return repository.findFoodById(id);
	}
}
