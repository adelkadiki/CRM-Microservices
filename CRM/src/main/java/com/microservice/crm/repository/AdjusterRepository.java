package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Adjuster;

public interface AdjusterRepository extends JpaRepository<Adjuster, Long> {

	Adjuster findAdjusterById(Long id);
}
