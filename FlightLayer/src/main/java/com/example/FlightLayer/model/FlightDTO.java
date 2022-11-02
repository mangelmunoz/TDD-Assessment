package com.example.FlightLayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private Integer id;

    private String flightName;

    private String company;

    private LocalDateTime departure;

    private LocalDateTime arrival;

    private String origin;

    private String destination;

    private Double price;

    private Integer availableSeats;

    private Boolean hasLuggagge;

    private Boolean hasReturn;

    private Integer returnFlight;

    private List<String> scales;

    private List<Integer> passengersIds;
}
