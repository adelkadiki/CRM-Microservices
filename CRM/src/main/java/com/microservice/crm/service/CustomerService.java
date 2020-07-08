package com.microservice.crm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.crm.model.Customer;
import com.microservice.crm.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	
	public Customer add(Customer customer) {
		return repository.save(customer);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Customer findById(Long id) {
		
		return repository.findCustomerById(id);
	}
	
	public List<Customer> getAllCustomers(){
		
		return repository.findAll();
	}

}
