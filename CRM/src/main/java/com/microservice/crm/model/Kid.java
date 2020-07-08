package com.microservice.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kid")
public class Kid {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="sport")
	private String sport;
	
	public Kid() {}
	
	

	public Kid(String name, int age, String sport) {
	
		this.name = name;
		this.age = age;
		this.sport = sport;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
	
	
	
	
	
}
