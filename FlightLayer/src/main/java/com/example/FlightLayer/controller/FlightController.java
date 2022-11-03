package com.example.FlightLayer.controller;

import com.example.FlightLayer.model.FlightDTO;
import com.example.FlightLayer.services.FlightServices;
import io.restassured.path.json.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightServices flightServices;

    @GetMapping
    public String getFlights(){
        return flightServices.getFlights();
    }

    @GetMapping(value = "/flight/{origin}")
    public String getFlightsByOrigin(@PathVariable(value = "origin") String origin){
        return flightServices.getFlightsByOrigin(origin);
    }

    @GetMapping(value = "/flight/filter/{origin}/{year}/{month}/{day}")
    public String getFlightsByOriginAndDate(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "month") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return flightServices.getFlightsByOriginAndDate(origin, year, month, day);
    }

    @GetMapping(value = "/flight/filter/{origin}/{destination}")
    public String getFlightsByOriginAndDestination(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "destination") String destination
    ){
        return flightServices.getFlightsByOriginAndDestination(origin,destination);
    }

    @GetMapping(value = "/flight/filter/{origin}/{destination}/{year}/{month}/{day}")
    public String getFlightsByOriginAndDestinationAndDate(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "destination") String destination,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "month") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return flightServices.getFlightsByOriginAndDestinationAndDate(origin, destination, year, month, day);
    }

    @GetMapping(value = "/flight/filter/type/{origin}/{type}/{year}/{month}/{day}")
    public String getFlightsByOriginAndDateAndTYpe(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "type") Boolean type,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "month") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return flightServices.getFlightsByOriginAndTypeAndDate(origin, type, year, month, day);
    }

    @GetMapping(value = "/flight/filter/{origin}/{destination}/{type}/{year}/{month}/{day}")
    public String getFlightsByOriginAndDestinationAndTypeAnsDate(
            @PathVariable(value = "origin") String origin,
            @PathVariable(value = "destination") String destination,
            @PathVariable(value = "year") Integer year,
            @PathVariable(value = "type") Boolean type,
            @PathVariable(value = "month") Integer month,
            @PathVariable(value = "day") Integer day
    ){
        return flightServices.getFlightsByOriginAndDestinationAndDateAndType(origin, destination, year, month, day, type);
    }


}
