package com.example.FlightLayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

public class FlightDTO {

    private Integer id;

    private String flightName;

    private String company;

    private LocalDateTime departure;

    private LocalDateTime arrival;

    private String origin;

    private String destination;

    private Double price;

    private List<String> scales;

    private List<Integer> passengersIds;
}
