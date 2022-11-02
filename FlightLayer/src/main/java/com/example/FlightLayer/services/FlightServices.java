package com.example.FlightLayer.services;

import com.example.FlightLayer.model.FlightDTO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Service
public class FlightServices {

    public FlightServices() {
        RestAssured.baseURI = "http://localhost:8080/api/persistence";
    }

    public String getFlights(){

        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI)
                .getBody().jsonPath();

        return statusCode.prettify();
    }

}
