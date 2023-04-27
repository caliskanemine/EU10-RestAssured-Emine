package com.cybertek.ApiShorts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpartanTestsWithPathParameters {

    String spartansBaseURL = "http://44.197.123.56:8000";

/*
    @BeforeClass
    public void setUpClass(){

        RestAssured.baseURI= "http://44.197.123.56:8000";

    }

 */




    /*
      Given accept type is Json
      And Id parameter value is 18
      When user sends GET request to /api/spartans/{id}
      Then response status code should be 200
      And response content-type: application/json;charset=UTF-8
      And "Allen" should be in response payload
       */
    @Test
    public void pathTest1() {

        Response response = RestAssured.given().accept(ContentType.JSON).
                pathParam("id", 18).
                when().get(spartansBaseURL+"/api/spartans/{id}");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.body().asString().contains("Allen"));

        response.body().prettyPrint();

    }

    @Test
    public void pathTest1Deneme() {

        Response response = RestAssured.given().accept(ContentType.JSON).
                pathParam("id", 18).
                and().when().get("http://44.197.123.56:8000/api/spartans/{id}");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.body().asString().contains("Allen"));

        response.body().prettyPrint();
    }


    /*
    Given accept type is Json
    And Id parameter value is 500
    When user sends GET request to /api/spartans/{id}
    Then response status code should be 404
    And response content-type: application/json
    And "Spartan Not Found" message should be in response payload
     */
    @Test
    public void negativePathParamTest() {


        Response response = RestAssured.given().accept(ContentType.JSON).
                pathParam("id", 200).
                when().get(spartansBaseURL + "/api/spartans/{id}");

        assertEquals(404, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Not Found"));
        System.out.println(response.body().asString().equals("Spartan Not Found"));

        response.prettyPrint();

    }


}
