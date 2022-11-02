package com.example.TDDAssessmentBackend.persistence.repository;

import com.example.TDDAssessmentBackend.persistence.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
