package com.example.TDDAssessmentBackend.persistence.services;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.models.dto.PassengerDTO;
import com.example.TDDAssessmentBackend.persistence.models.mapper.FlightMapper;
import com.example.TDDAssessmentBackend.persistence.models.mapper.PassengerMapper;
import com.example.TDDAssessmentBackend.persistence.repository.CountryRepository;
import com.example.TDDAssessmentBackend.persistence.repository.FlightRepository;
import com.example.TDDAssessmentBackend.persistence.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersistenceService {

    @Autowired
    public FlightRepository flightRepository;

    @Autowired
    public PassengerRepository passengerRepository;

    @Autowired
    public CountryRepository countryRepository;

    @Autowired
    public PassengerMapper passengerMapper;

    @Autowired
    public FlightMapper flightMapper;

    @Transactional
    public Passenger addPassengerToFlight(Passenger passenger){

        Flight chosenFlight = flightRepository.findById(passenger.getFlight().getId()).get();

        if( passenger.getYears() > 2 && passenger.getYears() < 9){
            passenger.setPrice(chosenFlight.getPrice()*0.5);
        }
        else if(passenger.getYears() < 2){
            passenger.setPrice(0.0);
        }
        else{
            passenger.setPrice(chosenFlight.getPrice());
        }

        Passenger passenger1 = passengerRepository.save(passenger);

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
        Passenger passenger1 = passengerMapper.fromPassengerDTOtoPassenger(passenger);
        passenger1.setPrice(0.0);
        return addPassengerToFlight(passenger1);
    }

    public List<Passenger> getPassengers(){
        return passengerRepository.findAll();
    }


    //TODO: Flights por ORIGEN, por DESTINO, si es IDA o IDA y VUELTA, por FECHA

    //TODO: Devolver nombre y datos de las ciudades

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public List<Flight> getFlightsByOrigin(String country){
        try {
            Country country1 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(country)).get();
            if (country1 != null) {
                return flightRepository.findByOrigin(country1).orElse(new ArrayList<>());
            } else return new ArrayList<>();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }

    public List<Flight> getFlightsByOriginAndDate(String country, LocalDateTime departure){
        try {
            Country country1 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(country)).get();
            if (country1 != null) {
                return flightRepository.findByOriginAndDeparture(country1, departure).orElse(new ArrayList<>());
            } else return new ArrayList<>();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }

    public List<Flight> getFlightsByOriginAndDestinationAndDate(String origin, String destination, LocalDateTime departure){
        try {
            Country country1 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(origin)).get();
            Country country2 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(destination)).get();
            if (country1 != null) {
                return flightRepository.findByOriginAndDestinationAndDepartureBetween(country1, country2, departure.minusDays(3), departure.plusDays(3)).orElse(new ArrayList<>());
            } else return new ArrayList<>();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }

    public List<Flight> getFlightsByOriginAndDateAndType(String origin, LocalDateTime departure, Boolean hasReturn){
        try {
            Country country1 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(origin)).get();
            if (country1 != null) {
                return flightRepository.findByOriginAndHasReturnAndDepartureBetween(country1, hasReturn, departure.minusDays(3), departure.plusDays(3)).orElse(new ArrayList<>());
            } else return new ArrayList<>();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }

    //TODO: Origen fecha destino y tipo.
    public List<Flight> getFlightByOriginAndDestinationAndDateAndType(String origin, String destination, LocalDateTime departure, Boolean hasReturn){
        try {
            Country country1 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(origin)).get();
            Country country2 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(destination)).get();
            if (country1 != null) {
                return flightRepository.findByOriginAndDestinationAndHasReturnAndDepartureBetween(country1, country2, hasReturn, departure.minusDays(3), departure.plusDays(3)).orElse(new ArrayList<>());
            } else return new ArrayList<>();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }

    //TODO: Origen destino
    public List<Flight> getFlightByOriginAndDestination(String origin, String destination){
        try {
            Country country1 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(origin)).get();
            Country country2 = countryRepository.findByCountry(flightMapper.fromStringtoECountry(destination)).get();
            if (country1 != null) {
                return flightRepository.findByOriginAndDestination(country1, country2).orElse(new ArrayList<>());
            } else return new ArrayList<>();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }
}
