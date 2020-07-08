package com.microservice.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Trade;
import com.microservice.crm.repository.CustomerRepository;
import com.microservice.crm.repository.TreadeRepository;

@Service
public class TradeService {

	
	@Autowired
	private TreadeRepository repository;
	
	
	public Trade add(Trade trade) {
		return repository.save(trade);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Trade findById(Long id) {
		
		return repository.findTradeById(id);
	}
}
