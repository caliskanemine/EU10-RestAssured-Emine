package com.cybertek.Day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ParametrizedTestInJunits {

    @ParameterizedTest
    @ValueSource(ints={1,3,5,6,7,9,10,5})
    public void testMultipleNumbers(int number){
        System.out.println("number = " + number);
        Assertions.assertTrue(number>5);
    }

    @ParameterizedTest
    @ValueSource(strings={"john", "abbas", "ali", "TJ"})
    public void testMultipleNames(String name){
        System.out.println("name = " + name);
    }


    //send GET REQUEST to https://api.zippopotam.us/us/{zipcode}
    //with these zipcodes 22030,22031,22032,22033,22034,22035,22035,22036
    //check status code 200

    @ParameterizedTest
    @ValueSource(ints = {22030,22031,22032,22033,22034,22035,22035,22036})
    public void zipCodeTest(int zipCode){

        given().baseUri("//https://api.zippopotam.us").
                pathParam("zipcode", zipCode).
                log().all(). //request log
                when().get("/us/{zipcode}").
                then().log().all(). //response log
                statusCode(200);


    }


}
