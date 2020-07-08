package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Flooring;

public interface FlooringRepository extends JpaRepository<Flooring, Long> {

	Flooring findFlooringById(Long id);
}
