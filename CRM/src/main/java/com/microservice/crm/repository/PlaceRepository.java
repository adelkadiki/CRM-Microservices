package com.microservice.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crm.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

	Place findPlaceById(Long id);
}
