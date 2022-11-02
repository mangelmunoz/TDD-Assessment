package com.example.TDDAssessmentBackend.persistence.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
