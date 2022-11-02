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
			Flight flight1 = persistenceService.addFlight(new Flight(1, "IBE-1234","IBERIA", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(2), new Country(1, ECountry.VALENCIA), new Country(2, ECountry.CORDOBA), 200.0, 50, true, false, null, new ArrayList<>(), new ArrayList<>()));
			Flight flight2 = persistenceService.addFlight(new Flight(2, "IBE-2234","IBERIA", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(2), new Country(2, ECountry.CORDOBA), new Country(1, ECountry.VALENCIA), 200.0, 50, true, true, flight1, new ArrayList<>(), new ArrayList<>()));

			Flight flight3 = persistenceService.addFlight(new Flight(3, "RYA-2234","RYANAIR", LocalDateTime.now().plusDays(6), LocalDateTime.now().plusDays(6).plusHours(2), new Country(4, ECountry.TARRAGONA), new Country(5, ECountry.SPARTA), 200.0, 50, true, false, null, new ArrayList<>(), new ArrayList<>()));
			Flight flight4 = persistenceService.addFlight(new Flight(4, "RYA-2234","RYANAIR", LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(5).plusHours(9), new Country(3, ECountry.TORREDONJIMENO), new Country(4, ECountry.TARRAGONA), 80.0, 50, true, false, null, new ArrayList<>(), new ArrayList<>()));
			Flight flight5 = persistenceService.addFlight(new Flight(5, "RYA-2234","RYANAIR", LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(5).plusHours(3), new Country(3, ECountry.TORREDONJIMENO), new Country(5, ECountry.SPARTA), 250.0, 50, true, false, null, List.of(new Country(4, ECountry.TARRAGONA)), new ArrayList<>()));

			Flight flight6 = persistenceService.addFlight(new Flight(6, "WIZ-2234","WIZZAIR", LocalDateTime.now().plusDays(7).plusHours(5), LocalDateTime.now().plusDays(7).plusHours(8), new Country(10, ECountry.MURCIA), new Country(5, ECountry.SPARTA), 250.0, 50, true, false, null, null, new ArrayList<>()));
			Flight flight7 = persistenceService.addFlight(new Flight(7, "WIZ-2234","WIZZAIR", LocalDateTime.now().plusDays(7).plusHours(1), LocalDateTime.now().plusDays(7).plusHours(3), new Country(6, ECountry.MILAN), new Country(10, ECountry.MURCIA), 250.0, 50, true, false, null, null, new ArrayList<>()));
			Flight flight8 = persistenceService.addFlight(new Flight(8, "WIZ-2234","WIZZAIR", LocalDateTime.now().plusDays(6).plusHours(4), LocalDateTime.now().plusDays(6).plusHours(8), new Country(1, ECountry.VALENCIA), new Country(6, ECountry.MILAN), 250.0, 50, true, false, null, null, new ArrayList<>()));
			Flight flight9 = persistenceService.addFlight(new Flight(9, "WIZ-2234","WIZZAIR", LocalDateTime.now().plusDays(6).plusHours(1), LocalDateTime.now().plusDays(6).plusHours(3), new Country(1, ECountry.VALENCIA), new Country(5, ECountry.SPARTA), 250.0, 50, true, false, null, List.of(new Country(6, ECountry.MILAN), new Country(10, ECountry.MURCIA)), new ArrayList<>()));

			Flight flight10 = persistenceService.addFlight(new Flight(10, "WIZ-2234","WIZZAIR", LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(5).plusHours(3), new Country(3, ECountry.TORREDONJIMENO), new Country(1, ECountry.VALENCIA), 250.0, 50, true, false, null, null, new ArrayList<>()));
			Flight flight11 = persistenceService.addFlight(new Flight(11, "WIZ-2234","WIZZAIR", LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(5).plusHours(3), new Country(5, ECountry.SPARTA), new Country(3, ECountry.TORREDONJIMENO), 250.0, 50, true, false, null, null, new ArrayList<>()));
			Flight flight12 = persistenceService.addFlight(new Flight(12, "WIZ-2234","WIZZAIR", LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(5).plusHours(3), new Country(5, ECountry.SPARTA), new Country(1, ECountry.VALENCIA), 250.0, 50, true, true, flight9, List.of(new Country(3, ECountry.TORREDONJIMENO)), new ArrayList<>()));


		};

	}
}
