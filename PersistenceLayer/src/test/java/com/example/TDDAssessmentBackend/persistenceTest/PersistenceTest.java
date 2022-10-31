package com.example.TDDAssessmentBackend.persistenceTest;

import com.example.TDDAssessmentBackend.persistence.models.Country;
import com.example.TDDAssessmentBackend.persistence.models.Flight;
import com.example.TDDAssessmentBackend.persistence.models.enums.ECountry;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
public class PersistenceTest {

    //TODO: comprobar que el precio se actualiza correctamente dependiendo de la edad.

    @Test
    public void whenUserAgeinferiorTo9_getDiscounts_isCorrect(){

        Flight flight = new Flight(1,"IBE-321", "Iberia", LocalDateTime.now().plusDays(Long.valueOf(10)),LocalDateTime.now().plusDays(Long.valueOf(11)), new Country(1, ECountry.VALENCIA), new Country(2, ECountry.CORDOBA), 80.0, new ArrayList<>(), new ArrayList<>());



        Assertions.assertTrue(true);
    }
}
