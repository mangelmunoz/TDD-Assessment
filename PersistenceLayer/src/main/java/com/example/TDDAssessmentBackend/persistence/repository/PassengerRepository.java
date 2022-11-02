package com.example.TDDAssessmentBackend.persistence.repository;

import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
