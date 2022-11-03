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

    @GetMapping(value = "/filter/{origin}")
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

}
