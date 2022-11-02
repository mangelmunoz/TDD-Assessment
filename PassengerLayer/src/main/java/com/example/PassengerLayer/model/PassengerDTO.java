package com.example.PassengerLayer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class PassengerDTO {

    private Integer id;

    private String name;

    private String surname;

    private String nationality;

    private String email;

    private String identification;

    private Integer years;

    private Boolean luggage;

    private Integer flightId;
}
