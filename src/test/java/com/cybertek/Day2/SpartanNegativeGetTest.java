package com.cybertek.Day2;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetTest {

    @BeforeAll //beforeAll is an annotation to beforeClass in testNg, we use with static method name
    public static void init() {

        //save baseurl inside this variable so that we dont need to type each http method
        baseURI = "http://44.197.123.56:8000";
    }

     /*TASK
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charset=UTF-8
    */
    @Test
    public void test(){
        Response response = get("/api/spartans");

    }

    @DisplayName("GET request to /api/spartans/10")
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON).
                when().get("/api/spartans/10");

        assertEquals(406, response.statusCode());

        assertEquals("application/xml;charset=UTF-8", response.contentType());

    }




}
