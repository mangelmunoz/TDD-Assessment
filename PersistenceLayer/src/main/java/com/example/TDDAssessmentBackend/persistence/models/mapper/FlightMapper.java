package com.example.TDDAssessmentBackend.persistence.models.mapper;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.dto.FlightDTO;
import com.example.TDDAssessmentBackend.persistence.models.enums.ECountry;
import com.example.TDDAssessmentBackend.persistence.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
@Slf4j
public abstract class FlightMapper {

    @Autowired
    protected FlightRepository flightRepository;

    public abstract ECountry fromStringtoECountry(String country);

//    @Mapping(source="origin", target = "origin.country")
//    @Mapping(source="destination", target = "destination.country")
//    @Mapping(source="returnFlight", target = "returnFlight.id")
//    @Mapping(source = "scales", target = "scales.id")
//    public abstract Flight fromFlightDTOtoFlight(FlightDTO flightDTO);
//
//
//    public abstract List mapIntegerToList(List country);
////    public abstract List<Integer> countryListToIntegerList(List<Country> countryList);
//
////    public abstract Integer countryToInteger(Country country);
//
//    public Integer mapScalesIdtoInteger(Country country){
//        return country.getId();
//    }
}
