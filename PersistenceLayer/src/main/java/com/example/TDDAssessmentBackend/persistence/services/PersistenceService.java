package com.example.TDDAssessmentBackend.persistence.services;

import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.models.dto.PassengerDTO;
import com.example.TDDAssessmentBackend.persistence.models.mapper.PassengerMapper;
import com.example.TDDAssessmentBackend.persistence.repository.FlightRepository;
import com.example.TDDAssessmentBackend.persistence.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersistenceService {

    @Autowired
    public FlightRepository flightRepository;

    @Autowired
    public PassengerRepository passengerRepository;

    @Autowired
    public PassengerMapper passengerMapper;

    @Transactional
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

        Passenger passenger1 = passengerRepository.save(passenger);

        Flight chosenFlight = flightRepository.findById(passenger.getFlight().getId()).get();
        if(chosenFlight != null){
            chosenFlight.getPassengers().add(passenger1);
            flightRepository.save(chosenFlight);
        }


        return passenger1;
    }

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }

    public Passenger addPassenger(PassengerDTO passenger){
        return passengerRepository.save(addPassengerToFlight(passengerMapper.fromPassengerDTOtoPassenger(passenger)));
    }

    public List<Passenger> getPassengers(){
        return passengerRepository.findAll();
    }

}
