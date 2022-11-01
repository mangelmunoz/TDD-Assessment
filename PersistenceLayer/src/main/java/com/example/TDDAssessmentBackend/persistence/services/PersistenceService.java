package com.example.TDDAssessmentBackend.persistence.services;

import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.repository.FlightRepository;
import com.example.TDDAssessmentBackend.persistence.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersistenceService {

    @Autowired
    public FlightRepository flightRepository;

    @Autowired
    public PassengerRepository passengerRepository;

    public Passenger addPassengerToFlight(Passenger passenger){

        if( passenger.getYears() > 2 && passenger.getYears() < 9){
            passenger.setPrice(passenger.getFlight().getPrice()*0.5);
        }
        else if(passenger.getYears() < 2){
            passenger.setPrice(0.0);
        }
        else{
            passenger.setPrice(passenger.getFlight().getPrice());
        }

        return passengerRepository.save(passenger);
    }

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }

}
