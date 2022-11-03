package com.example.TDDAssessmentBackend.persistence.controller;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.models.dto.PassengerDTO;
import com.example.TDDAssessmentBackend.persistence.models.enums.ECountry;
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

    @GetMapping(value = "/origins")
    public List<Country> getOrigins(@PathVariable(value = "origin") String origin){
        return persistenceService.getOrigins();
    }

    @GetMapping(value = "/destinations/{origin}")
    public List<Country> getDestinations(@PathVariable(value = "origin") String origin){
        return persistenceService.getDestinations(origin);
    }

    @PostMapping(value = "/passenger/add")
    public Passenger addPassenger(@RequestBody PassengerDTO passenger){

        return persistenceService.addPassenger(passenger);
    }

    @GetMapping(value = "/passenger")
    public List<Passenger> getPassengers(){
        return persistenceService.getPassengers();
    }

    @GetMapping(value = "/flight/filter/{origin}")
    public List<Flight> getFlightsByOrigin(@PathVariable(value = "origin") String origin){
        return persistenceService.getFlightsByOrigin(origin);
    }

    @GetMapping(value = "/flight/filter/{origin}/{year}/{month}/{day}")
    public List<Flight> getFlightsByOriginAndDate(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "day") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return persistenceService.getFlightsByOrigin(origin);
    }

    @GetMapping(value = "/flight/filter/{origin}/{destination}/{year}/{month}/{day}")
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

    @GetMapping(value = "/flight/filter/{origin}/{destination}")
    public List<Flight> getByOriginAndDestination(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "destination") String destination){
        return persistenceService.getFlightsByOriginAndDestination(origin,destination);
    }

    @GetMapping(value = "/flight/filter/{origin}/{destination}/{hasReturn}/{year}/{month}/{day}")
    public List<Flight> getFlightsByOriginAndDestinationAndDateAndType(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "destination") String destination,
            @PathVariable(value = "hasReturn") Boolean hasReturn,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "month") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return persistenceService.getFlightByOriginAndDestinationAndDateAndType(origin, destination, LocalDateTime.of(year,month,day,0,0), hasReturn);
    }

    @GetMapping(value = "/flight/filter/type/{origin}/{hasReturn}/{year}/{month}/{day}")
    public List<Flight> getFlightsByOriginAndDateAndType(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "hasReturn") Boolean hasReturn,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "month") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return persistenceService.getFlightsByOriginAndDateAndType(origin, LocalDateTime.of(year,month,day,0,0), hasReturn);
    }

}
