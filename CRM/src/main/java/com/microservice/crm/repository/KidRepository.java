package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Kid;

public interface KidRepository extends JpaRepository<Kid, Long> {

	Kid findKidById(Long id);
}
