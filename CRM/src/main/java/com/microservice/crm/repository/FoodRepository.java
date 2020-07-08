package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

	Food findFoodById(Long id);
}
