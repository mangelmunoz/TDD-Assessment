package com.example.TDDAssessmentBackend.flightTest;

import com.example.FlightLayer.services.FlightServices;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightTest {

    @Autowired
    public FlightServices flightServices;

    @Test
    public void test(){
        Assertions.assertTrue(true);
    }

//    @Test
//    public void getFlightsByOrigin_getFlightsList_withOriginTrue(){
//
//        String getFlightsByOrigin = flightServices.getFlightsByOrigin("VALENCIA");
//
//        System.out.println(getFlightsByOrigin);
//        Assertions.assertNotNull(getFlightsByOrigin);
//    }
}
