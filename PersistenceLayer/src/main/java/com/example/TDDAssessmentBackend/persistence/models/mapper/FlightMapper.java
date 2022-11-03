package com.example.TDDAssessmentBackend.persistence.models.mapper;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.enums.ECountry;
import com.example.TDDAssessmentBackend.persistence.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Slf4j
public abstract class FlightMapper {

    @Autowired
    protected FlightRepository flightRepository;

    public abstract ECountry fromStringtoECountry(String country);
}
