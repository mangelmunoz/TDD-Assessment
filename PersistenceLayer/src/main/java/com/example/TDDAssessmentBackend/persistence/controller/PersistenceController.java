package com.example.TDDAssessmentBackend.persistence.controller;

import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.services.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/api/persistence")
public class PersistenceController {

    @Autowired
    public PersistenceService persistenceService;

    @GetMapping
    public List<Flight> getFlights(){
        return persistenceService.getFlights();
    }

}
