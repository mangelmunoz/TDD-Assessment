package com.example.TDDAssessmentBackend.persistence.controller;

import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.models.dto.PassengerDTO;
import com.example.TDDAssessmentBackend.persistence.models.mapper.FlightMapper;
import com.example.TDDAssessmentBackend.persistence.services.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping(value = "/flight/origin/{origin}/{year}/{month}/{day}")
    public List<Flight> getFlightsByOriginAndDate(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "day") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return persistenceService.getFlightsByOrigin(origin);
    }

    @GetMapping(value = "/flight/origin/{origin}/{destination}/{year}/{month}/{day}")
    public List<Flight> getFlightsByOriginAndDestinationAndDate(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "destination") String destination,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "month") Integer month,
            @PathVariable(value = "day") Integer day
    ){

        LocalDateTime date = LocalDateTime.of(year, month, day, 0, 0);
        return persistenceService.getFlightsByOriginAndDestinationAndDate(origin, destination, date);
    }

}
