package com.example.PassengerLayer.services;

import com.example.PassengerLayer.model.PassengerDTO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Service
public class PassengerService {

    public PassengerService(){
        RestAssured.baseURI = "http://localhost:8080/api/persistence";
    }

    public String addPassenger(PassengerDTO passengerDTO) {

        passengerDTO.setEmail(sendEmail(passengerDTO.getEmail()));

        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .body(passengerDTO)
                .when()
                .post(baseURI + "/passenger/add")
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String sendEmail(String email){

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()){
            return email + " - email sended";
        }

        return email + " - email not sended";
    }
}
