package com.example.TDDAssessmentBackend.persistenceTest;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.Passenger;
import com.example.TDDAssessmentBackend.persistence.models.enums.ECountry;
import com.example.TDDAssessmentBackend.persistence.services.PersistenceService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersistenceTest {

    //TODO: comprobar que el precio se actualiza correctamente dependiendo de la edad.

    @Autowired
    private PersistenceService persistenceService;

    @Test
    public void whenUserAgeinferiorTo9_getDiscounts_isCorrect(){

        Flight flight = persistenceService.addFlight(new Flight(1000, "IBE-1234","IBERIA", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(2), new Country(1, ECountry.VALENCIA), new Country(2, ECountry.CORDOBA), 200.0, 50, true, false, null, new ArrayList<>(), new ArrayList<>()));

        Passenger passenger = persistenceService.addPassengerToFlight(new Passenger(1, "Test", "Test", "Nationality Test","email@email.com", "Identification test", 18, true, null, flight));
        Passenger passenger_under9 = persistenceService.addPassengerToFlight(new Passenger(2, "Test9", "Test9", "Nationality Test","email@email.com", "Identification test", 7, true, null, flight));
        Passenger passenger_under2 = persistenceService.addPassengerToFlight(new Passenger(3, "Test2", "Test2", "Nationality Test","email@email.com", "Identification test", 1, true, null, flight));

        Assertions.assertEquals(flight.getPrice(), passenger.getPrice());
        Assertions.assertEquals(flight.getPrice() * 0.5, passenger_under9.getPrice());
        Assertions.assertEquals(0, passenger_under2.getPrice());
    }

    @Test
    public void whenOriginSelected_getListFromOrigin_returnsList(){

        List<Flight> getFlightsByOrigin = persistenceService.getFlightsByOrigin("VALENCIA");
        List<Flight> getFlightsByOriginWrong = persistenceService.getFlightsByOrigin("KINGSTON");

        Assertions.assertNotEquals(0, getFlightsByOrigin.size());
        Assertions.assertEquals(0, getFlightsByOriginWrong.size());
    }

    @Test
    public void whenOriginAndDestinationSelected_getListFromOriginAndDestination_returnsList(){

        List<Flight> getFlightsByOriginAndDestination = persistenceService.getFlightsByOriginAndDestination("VALENCIA", "CORDOBA");
        List<Flight> getFlightsByOriginAndDestinationWrong = persistenceService.getFlightsByOriginAndDestination("VALENCIA", "KINGSTON");

        Assertions.assertNotEquals(0, getFlightsByOriginAndDestination.size());
        Assertions.assertEquals(0, getFlightsByOriginAndDestinationWrong.size());
    }

    @Test
    public void givenOriginAndDate_whenOriginAndDateSelected_returnListWithDateRange(){
        List<Flight> getFlightsByOriginAndDate = persistenceService.getFlightsByOriginAndDate("VALENCIA", LocalDateTime.of(2022,11,07,0,0));
        List<Flight> getFlightsByOriginAndDate1 = persistenceService.getFlightsByOriginAndDate("VALENCIA", LocalDateTime.of(2024,11,07,0,0));

        Assertions.assertNotEquals(0,getFlightsByOriginAndDate.size());
        Assertions.assertEquals(0, getFlightsByOriginAndDate1.size());

    }

    @Test
    public void givenOriginAndDestinationAndDate_whenOriginAndDestinationAndDateSelected_returnListWithDateRange(){
        List<Flight> getFlightsByOriginAndDestinationAndDate = persistenceService.getFlightsByOriginAndDestinationAndDate("VALENCIA", "CORDOBA", LocalDateTime.of(2022,11,07,0,0));
        List<Flight> getFlightsByOriginAndDestinationAndDate1 = persistenceService.getFlightsByOriginAndDestinationAndDate("VALENCIA", "CORDOBA", LocalDateTime.of(2022,11,07,0,0));

        Assertions.assertNotEquals(0,getFlightsByOriginAndDestinationAndDate.size());
        Assertions.assertEquals(0, getFlightsByOriginAndDestinationAndDate1.size());
    }

    @Test
    public void givenOriginAndTypeAndDate_whenOriginAndTypeAndDateSelected_returnListWithDateRange(){
        List<Flight> getFlights = persistenceService.getFlightsByOriginAndDateAndType("VALENCIA", LocalDateTime.of(2022,11,07,0,0), false);
        List<Flight> getFlights1 = persistenceService.getFlightsByOriginAndDateAndType("VALENCIA", LocalDateTime.of(2022,11,07,0,0), true);

        Assertions.assertNotEquals(0,getFlights.size());
        Assertions.assertEquals(0, getFlights1.size());
    }
    @Test
    public void givenOriginAndDestinationAndTypeAndDate_whenOriginAndDestinationAndTypeAndDateSelected_returnListWithDateRange(){
        List<Flight> getFlights = persistenceService.getFlightByOriginAndDestinationAndDateAndType("VALENCIA", "CORDOBA", LocalDateTime.of(2022,11,07,0,0), false);
        List<Flight> getFlights1 = persistenceService.getFlightByOriginAndDestinationAndDateAndType("VALENCIA", "CORDOBA", LocalDateTime.of(2022,11,07,0,0), true);

        Assertions.assertNotEquals(0,getFlights.size());
        Assertions.assertEquals(0, getFlights1.size());
    }
}
