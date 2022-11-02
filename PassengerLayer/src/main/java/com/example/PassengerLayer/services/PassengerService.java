package com.example.PassengerLayer.services;

import com.example.PassengerLayer.model.PassengerDTO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Service
public class PassengerService {

    public PassengerService(){
        RestAssured.baseURI = "http://localhost:8080/api/persistence";
    }

    public String addPassenger(PassengerDTO passengerDTO) {

        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .post(baseURI + "/passenger/add")
                .getBody().jsonPath();

        return statusCode.prettify();
    }
}
