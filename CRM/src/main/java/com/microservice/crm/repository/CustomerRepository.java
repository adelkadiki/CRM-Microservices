package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.microservice.crm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findCustomerById(Long id);
	
}
