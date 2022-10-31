package com.example.TDDAssessmentBackend.persistence.services;

import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.repository.FlightRepository;
import com.example.TDDAssessmentBackend.persistence.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistenceService {

    @Autowired
    public FlightRepository flightRepository;

    @Autowired
    public PassengerRepository passengerRepository;

    public Passenger addPassengerToFlight(Passenger passenger){

        if( passenger.getYears() > 2 && passenger.getYears() < 9){
            passenger.getFlight().setPrice(passenger.getFlight().getPrice()*0.5);
        }

        if(passenger.getYears() < 2){
            passenger.getFlight().setPrice(0.0);
        }

        return passengerRepository.save(passenger);
    }

}
