package com.example.TDDAssessmentBackend.persistence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String nationality;

    @Column
    private String identification;

    @Column
    private Integer years;

    @Column
    private Boolean luggage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_flight")
    private Flight flight;
}
