package com.example.TDDAssessmentBackend.persistence.repository;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<List<Flight>> findByOrigin(Country country);
    Optional<List<Flight>> findByOriginAndDestination(Country origin, Country destination);

}
