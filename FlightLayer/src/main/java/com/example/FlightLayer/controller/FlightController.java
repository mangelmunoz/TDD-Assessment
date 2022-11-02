package com.example.FlightLayer.controller;

import com.example.FlightLayer.model.FlightDTO;
import com.example.FlightLayer.services.FlightServices;
import io.restassured.path.json.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    private FlightServices flightServices;

    @GetMapping
    public String getFlights(){
        return flightServices.getFlights();
    }

}
