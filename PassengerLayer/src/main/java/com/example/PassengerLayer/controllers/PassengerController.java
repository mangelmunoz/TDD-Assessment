package com.example.PassengerLayer.controllers;

import com.example.PassengerLayer.model.PassengerDTO;
import com.example.PassengerLayer.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passenger")
@CrossOrigin
public class PassengerController {

    @Autowired
    public PassengerService passengerService;

    @PostMapping(value = "/add")
    public String addPassenger(@RequestBody PassengerDTO passengerDTO){
        return passengerService.addPassenger(passengerDTO);
    }
}
