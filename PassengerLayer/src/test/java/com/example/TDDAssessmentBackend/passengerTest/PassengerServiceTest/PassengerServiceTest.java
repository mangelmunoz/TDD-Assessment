package com.example.TDDAssessmentBackend.passengerTest.PassengerServiceTest;

import com.example.PassengerLayer.services.PassengerService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PassengerServiceTest {

    @Autowired
    private PassengerService passengerService;

    @Test
    public void when_given_then(){
        Assertions.assertTrue(true);
    }
}
