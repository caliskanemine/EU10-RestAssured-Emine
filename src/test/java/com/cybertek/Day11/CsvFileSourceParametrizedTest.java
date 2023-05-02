package com.cybertek.Day11;

import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class CsvFileSourceParametrizedTest {

    //write a parametrized test for this request
    //get the data from csv source
    //GET https://api.zippopotam.us/us/{state}/{city}

    @ParameterizedTest
    @CsvFileSource(resources = "/postalcode.csv", numLinesToSkip = 1)  //we want to skip first line, otherwise it will take it as a parameter
    public void zipCodeTestWithFile(String stateArg, String cityArg, int zipCountArg){

        System.out.println("stateArg = " + stateArg);
        System.out.println("cityArg = " + cityArg);
        System.out.println("zipCountArg = " + zipCountArg);

        //send a request and verify place number matches with zipCount
        given().baseUri("https://api.zippopotam.us").accept(ContentType.JSON).
                pathParam("state", stateArg).
                pathParam("city", cityArg).
                log().uri().
                when().get("/us/{state}/{city}").
                then().statusCode(200).
                body("places", hasSize(zipCountArg));



    }


}
