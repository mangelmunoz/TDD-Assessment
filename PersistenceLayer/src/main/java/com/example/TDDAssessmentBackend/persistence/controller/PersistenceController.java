package com.example.TDDAssessmentBackend.persistence.controller;

import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.models.dto.PassengerDTO;
import com.example.TDDAssessmentBackend.persistence.models.mapper.FlightMapper;
import com.example.TDDAssessmentBackend.persistence.services.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persistence")
public class PersistenceController {

    @Autowired
    public PersistenceService persistenceService;

    @Autowired
    public FlightMapper flightMapper;

    @GetMapping
    public List<Flight> getFlights(){
        return persistenceService.getFlights();
    }

    @PostMapping(value = "/passenger/add")
    public Passenger addPassenger(@RequestBody PassengerDTO passenger){

        return persistenceService.addPassenger(passenger);
    }

    @GetMapping(value = "/passenger")
    public List<Passenger> getPassengers(){
        return persistenceService.getPassengers();
    }

    @GetMapping(value = "/flight/origin/{origin}")
    public List<Flight> getFlightsByOrigin(@PathVariable(value = "origin") String origin){
        return persistenceService.getFlightsByOrigin(origin);
    }

}
