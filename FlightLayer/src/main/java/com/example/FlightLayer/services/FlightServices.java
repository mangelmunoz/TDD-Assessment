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

    public String getOrigins(){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/origins")
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String getDestinations(String origin){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/destinations/" + origin)
                .getBody().jsonPath();

        return statusCode.prettify();
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
                .get(baseURI + "/flight/filter/" + country)
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String getFlightsByOriginAndDestination(String country, String destination){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/filter/" + country + "/" + destination)
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String getFlightsByOriginAndDate(String country, Integer year, Integer month, Integer day){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/filter/" + country + "/" + year + "/"+ month + "/"+ day)
                .getBody().jsonPath();

        return statusCode.prettify();
    }
    public String getFlightsByOriginAndDestinationAndDate(String origin, String destination, Integer year, Integer month, Integer day){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/filter/" + origin + "/" + destination + "/" + year + "/"+ month + "/"+ day)
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String getFlightsByOriginAndTypeAndDate(String origin, Boolean type, Integer year, Integer month, Integer day){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/filter/type/" + origin + "/" + type + "/" + year + "/"+ month + "/"+ day)
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String getFlightsByOriginAndDestinationAndDateAndType(String origin, String destination, Integer year, Integer month, Integer day, Boolean type){
        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/filter/" + origin + "/" + destination + "/" + type + "/" + year + "/"+ month + "/"+ day )
                .getBody().jsonPath();

        return statusCode.prettify();
    }

    public String getFlightByOriginAndDestinationAndDateAndType(String origin, String destination, Boolean hasReturn, Integer year, Integer month, Integer day){

        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/flight/filter/" + origin + "/" + destination + "/" + hasReturn + "/"+ year + "/"+ month + "/"+ day)
                .getBody().jsonPath();

        return statusCode.prettify();

    }

    public String getFlightById(Integer id){

        JsonPath statusCode = given()
                .header("Content-Type","application/json")
                .when()
                .get(baseURI + "/searchFlight/" + id)
                .getBody().jsonPath();

        return statusCode.prettify();

    }

}
