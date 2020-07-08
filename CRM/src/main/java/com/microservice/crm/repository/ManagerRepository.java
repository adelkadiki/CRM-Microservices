package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

	Manager findManagerById(Long id);
}
