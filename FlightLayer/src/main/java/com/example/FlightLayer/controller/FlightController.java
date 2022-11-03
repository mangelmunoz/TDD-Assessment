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

    @GetMapping(value = "/origin/{origin}")
    public String getFlightsByOrigin(@PathVariable(value = "origin") String origin){
        return flightServices.getFlightsByOrigin(origin);
    }

}
