package com.example.FlightLayer.services;

import com.example.FlightLayer.model.FlightDTO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public String getFlightsByOrigin(String country){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/origin/" + country)
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String getFlightsByOriginAndDate(String country, Integer year, Integer month, Integer day){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/origin/" + country + "/" + year + "/"+ month + "/"+ day)
                .getBody().jsonPath();

        return statusCode.prettify();
    }
    public String getFlightsByOriginAndDestinationAndDate(String origin, String destination, Integer year, Integer month, Integer day){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/origin/" + origin + "/" + destination + "/" + year + "/"+ month + "/"+ day)
                .getBody().jsonPath();

        return statusCode.prettify();
    }

}
