package com.example.PassengerLayer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {

    private String name;

    private String surname;

    private String nationality;

    private String email;

    private String identification;

    private Integer years;

    private Boolean luggage;

    private Integer flightId;
}
