package com.example.TDDAssessmentBackend.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String flightName;

    @Column
    private String company;

    @Column
    private LocalDateTime departure;

    @Column
    private LocalDateTime arrival;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private Float price;

    @OneToMany(mappedBy = "flight", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Passenger> passengers;
}
