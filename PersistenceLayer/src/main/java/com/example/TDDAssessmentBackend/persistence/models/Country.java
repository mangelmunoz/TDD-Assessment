package com.example.TDDAssessmentBackend.persistence.models;

import com.example.TDDAssessmentBackend.persistence.models.enums.ECountry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ECountry country;
}
