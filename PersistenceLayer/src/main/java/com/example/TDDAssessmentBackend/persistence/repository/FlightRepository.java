package com.example.TDDAssessmentBackend.persistence.repository;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<List<Flight>> findByOrigin(Country country);

    Optional<List<Flight>> findByOriginAndDestination(Country origin, Country destination);

    Optional<List<Flight>> findByDepartureBetween(LocalDateTime start, LocalDateTime end);

    @Query("select f from Flight f where f.origin = ?1 and f.departure between ?2 and ?3")
    Optional<List<Flight>> findByOriginAndDepartureBetween(Country origin, LocalDateTime departure, LocalDateTime departure1);

    Optional<List<Flight>> findByOriginAndDestinationAndDepartureBetween(Country origin, Country destination, LocalDateTime departure, LocalDateTime departure1);

    Optional<List<Flight>> findByOriginAndHasReturnAndDepartureBetween(Country origin, Boolean hasReturn, LocalDateTime departure, LocalDateTime departure1);

    Optional<List<Flight>> findByOriginAndDestinationAndHasReturnAndDepartureBetween(Country origin, Country destination, Boolean hasReturn, LocalDateTime departure, LocalDateTime departure1);

}
