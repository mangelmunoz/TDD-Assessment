package com.example.TDDAssessmentBackend;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.enums.ECountry;
import com.example.TDDAssessmentBackend.persistence.services.PersistenceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TddAssessmentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddAssessmentBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PersistenceService persistenceService){

		return args -> {
			Flight flight1 = persistenceService.addFlight(new Flight(1, "IBE-1234","IBERIA", LocalDateTime.of(2022,11,9,12,30), LocalDateTime.of(2022,11,9,13,30), new Country(1, ECountry.VALENCIA), new Country(2, ECountry.CORDOBA), 200.0, 50, true, 15.0, false, null, new ArrayList<>(), new ArrayList<>()));
			Flight flight2 = persistenceService.addFlight(new Flight(2, "IBE-2234","IBERIA", LocalDateTime.of(2022,11,6,12,30), LocalDateTime.of(2022,11,06,13,30), new Country(2, ECountry.CORDOBA), new Country(1, ECountry.VALENCIA), 200.0, 50, true, 15.0,true, flight1, new ArrayList<>(), new ArrayList<>()));

			Flight flight3 = persistenceService.addFlight(new Flight(3, "RYA-2234","RYANAIR", LocalDateTime.of(2022,11,9,19,30), LocalDateTime.of(2022,11,9,22,30), new Country(4, ECountry.TARRAGONA), new Country(5, ECountry.SPARTA), 200.0, 50, true, 25.0,false, null, new ArrayList<>(), new ArrayList<>()));
			Flight flight4 = persistenceService.addFlight(new Flight(4, "RYA-2234","RYANAIR", LocalDateTime.of(2022,11,9,15,30), LocalDateTime.of(2022,11,9,17,30), new Country(3, ECountry.TORREDONJIMENO), new Country(4, ECountry.TARRAGONA), 80.0, 50, true, 25.0, false, null, new ArrayList<>(), new ArrayList<>()));
			Flight flight5 = persistenceService.addFlight(new Flight(5, "RYA-2234","RYANAIR", LocalDateTime.of(2022,11,9,12,30), LocalDateTime.of(2022,11,9,13,30), new Country(3, ECountry.TORREDONJIMENO), new Country(5, ECountry.SPARTA), 250.0, 50, true, 25.0, false, null, List.of(new Country(4, ECountry.TARRAGONA)), new ArrayList<>()));

			Flight flight6 = persistenceService.addFlight(new Flight(6, "WIZ-2234","WIZZAIR", LocalDateTime.of(2022,11,12,22,30), LocalDateTime.of(2022,11,12,23,30), new Country(7, ECountry.MURCIA), new Country(5, ECountry.SPARTA), 250.0, 50, true,30.0, false, null, null, new ArrayList<>()));
			Flight flight7 = persistenceService.addFlight(new Flight(7, "WIZ-2234","WIZZAIR", LocalDateTime.of(2022,11,12,18,30), LocalDateTime.of(2022,11,12,21,30), new Country(6, ECountry.MILAN), new Country(7, ECountry.MURCIA), 250.0, 50, true, 30.0, false, null, null, new ArrayList<>()));
			Flight flight8 = persistenceService.addFlight(new Flight(8, "WIZ-2234","WIZZAIR", LocalDateTime.of(2022,11,12,13,30), LocalDateTime.of(2022,11,12,15,30), new Country(1, ECountry.VALENCIA), new Country(6, ECountry.MILAN), 250.0, 50, true, 30.0, false, null, null, new ArrayList<>()));
			Flight flight9 = persistenceService.addFlight(new Flight(9, "WIZ-2234","WIZZAIR", LocalDateTime.of(2022,11,12,9,30), LocalDateTime.of(2022,11,12,11,30), new Country(1, ECountry.VALENCIA), new Country(5, ECountry.SPARTA), 250.0, 50, true, 30.0, false, null, List.of(new Country(6, ECountry.MILAN), new Country(7, ECountry.MURCIA)), new ArrayList<>()));

			Flight flight10 = persistenceService.addFlight(new Flight(10, "WIZ-2234","WIZZAIR", LocalDateTime.of(2022,11,9,21,30), LocalDateTime.of(2022,11,9,23,30), new Country(3, ECountry.TORREDONJIMENO), new Country(1, ECountry.VALENCIA), 250.0, 50, true, 30.0, false, null, null, new ArrayList<>()));
			Flight flight11 = persistenceService.addFlight(new Flight(11, "WIZ-2234","WIZZAIR", LocalDateTime.of(2022,11,9,18,30), LocalDateTime.of(2022,11,9,20,30), new Country(5, ECountry.SPARTA), new Country(3, ECountry.TORREDONJIMENO), 250.0, 50, true, 30.0, false, null, null, new ArrayList<>()));
			Flight flight12 = persistenceService.addFlight(new Flight(12, "WIZ-2234","WIZZAIR", LocalDateTime.of(2022,11,9,12,30), LocalDateTime.of(2022,11,9,16,30), new Country(5, ECountry.SPARTA), new Country(1, ECountry.VALENCIA), 250.0, 50, true, 30.0, true, flight9, List.of(new Country(3, ECountry.TORREDONJIMENO)), new ArrayList<>()));

			Flight flight13 = persistenceService.addFlight(new Flight(13, "IBE-2734","IBERIA", LocalDateTime.of(2022,11,6,12,30), LocalDateTime.of(2022,11,06,13,30), new Country(2, ECountry.CORDOBA), new Country(1, ECountry.VALENCIA), 200.0, 50, true, 15.0,false, null, new ArrayList<>(), new ArrayList<>()));

		};

	}
}
