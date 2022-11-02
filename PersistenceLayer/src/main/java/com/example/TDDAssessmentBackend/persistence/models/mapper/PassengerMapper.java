package com.example.TDDAssessmentBackend.persistence.models.mapper;

import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.models.dto.PassengerDTO;
import com.example.TDDAssessmentBackend.persistence.repository.PassengerRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Slf4j
public abstract class PassengerMapper {

    @Autowired
    protected PassengerRepository passengerRepository;

    @Mapping(source = "flightId", target = "flight.id")
    public abstract Passenger fromPassengerDTOtoPassenger(PassengerDTO passengerDTO);
}
