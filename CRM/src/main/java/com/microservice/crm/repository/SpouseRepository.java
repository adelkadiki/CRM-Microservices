package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Spouse;

public interface SpouseRepository extends JpaRepository<Spouse, Long> {
	
	Spouse findSpouseById(Long id);

}
