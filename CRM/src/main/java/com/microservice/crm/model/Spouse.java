package com.microservice.crm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="spouse")
public class Spouse {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="interest")
	private String interest;
	
	@Column(name="occupation")
	private String occupation;
	
	@OneToOne(mappedBy="spouse")
	private Customer customer;
	
	
	public Spouse() {}

   
	
	public Spouse(String name, String interest, String occupation, Customer customer) {
		
		this.name = name;
		this.interest = interest;
		this.occupation = occupation;
		this.customer = customer;
	}

    

	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
}
