package com.example.TDDAssessmentBackend.passengerTest;

import com.example.PassengerLayer.model.PassengerDTO;
import com.example.PassengerLayer.services.PassengerService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class PassengerTest {
    @Autowired
    private PassengerService passengerService;

    @Test
    public void when_given_then(){
        Assertions.assertTrue(true);
    }

    //Comprobar que se envía un email al usuario cuando se registra
    @Test
    public void whenPassengerCreate_withEmail_sendEmail(){
        PassengerDTO passengerDTO = new PassengerDTO(100, "testName", "testSurname", "testNatio", "email@email.com", "testIdentification",25,true,1);

        String passengerEmail = passengerService.sendEmail(passengerDTO.getEmail());
        String expectedEmail = "email@email.com - email sended";

        Assertions.assertEquals(expectedEmail, passengerDTO.getEmail());
    }
}
