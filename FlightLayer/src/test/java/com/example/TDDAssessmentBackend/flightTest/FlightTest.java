package com.example.TDDAssessmentBackend.flightTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightTest {

    @Test
    public void givenAListOfOrigins_whenOriginSelected_returnAListOfDestinations(){



    }

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
