package com.microservice.crm.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="DOB")
	private LocalDate dob ;

	@Column(name="married")
	private boolean married;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="spouse_id", referencedColumnName="id")
	private Spouse spouse;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "id")
	private Set<Adjuster> adjusters;
	 
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "id") 
	private Set<Flooring> floorings; 
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "id") 
	private Set<Manager> managers;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "id") 
	private Set<Place> places;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "id") 
	private Set<Trade> trades;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "id") 
	private Set<Food> food;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "id") 
	private Set<Kid> kids;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "id") 
	private Set<Sport> sports;
	
	
	public Customer() {}
	
				
	public Customer(String name, String address, LocalDate dob, boolean married, Spouse spouse, Set<Adjuster> adjusters,
			Set<Flooring> floorings, Set<Manager> managers, Set<Place> places, Set<Trade> trades, Set<Food> food,
			Set<Kid> kids, Set<Sport> sports) {
		
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.married = married;
		this.spouse = spouse;
		this.adjusters = adjusters;
		this.floorings = floorings;
		this.managers = managers;
		this.places = places;
		this.trades = trades;
		this.food = food;
		this.kids = kids;
		this.sports = sports;
	}





	public Spouse getSpouse() {
		return spouse;
	}





	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}





	public Set<Kid> getKids() {
		return kids;
	}





	public void setKids(Set<Kid> kids) {
		this.kids = kids;
	}





	public Set<Sport> getSports() {
		return sports;
	}





	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}





	public Set<Adjuster> getAdjusters() {
		return adjusters;
	}

	public void setAdjusters(Set<Adjuster> adjusters) {
		this.adjusters = adjusters;
	}


	public Set<Flooring> getFloorings() {
		return floorings;
	}

	public void setFloorings(Set<Flooring> floorings) {
		this.floorings = floorings;
	}

	public Set<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}


	public Set<Food> getFood() {
		return food;
	}


	public void setFood(Set<Food> food) {
		this.food = food;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	

	

	
}
