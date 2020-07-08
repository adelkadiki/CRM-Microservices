package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {

	Sport findSportById(Long id);
}
