package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Trade;

public interface TreadeRepository extends JpaRepository<Trade, Long> {

	Trade findTradeById(Long id);
}
