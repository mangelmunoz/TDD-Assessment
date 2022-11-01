package com.example.PassengerLayer.model;

import javax.persistence.Entity;

@Entity
public class PassengerDTO {

    private Integer id;

    private String name;

    private String surname;

    private String nationality;

    private String identification;

    private Integer years;

    private Boolean luggage;

    private Double price;

    private Integer flightId;
}
