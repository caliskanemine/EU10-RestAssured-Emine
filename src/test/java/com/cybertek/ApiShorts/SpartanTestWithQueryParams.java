package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestWithQueryParams extends SpartanTestBase {


    /*
    Given accept type is Json
    And query parameter values are:
    gender/female
    nameContains/j
    When user sends GET request to /api/spartans/search
    Then response status code should be 200
    And response content-type: applicaiton/json
    And "Female" should be in response payload
    And "Janette" should be in response payload
     */

    @Test
    public void queryParam1(){

        Response response = given().accept(ContentType.JSON).
                and().queryParam("gender", "Female").
                and().queryParam("nameContains", "J").
                when().get("api/spartans/search");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertFalse(response.body().asString().contains("Male")); //male olmadığını doğrula
        assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();



    }

    @Test
    public void queryParams2(){

        Map<String, Object> paramsMap= new HashMap<>();
        paramsMap.put("gender", "Female");
        paramsMap.put("nameContains", "J");

        Response response = given().accept(ContentType.JSON).
                when().queryParams(paramsMap).
                when().get("/api/spartans/search");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertFalse(response.body().asString().contains("Male")); //male olmadığını doğrula
        assertTrue(response.body().asString().contains("Janette"));


        response.prettyPrint();


    }

    @Test
    public void queryParam1Deneme(){


        Response response = given().accept(ContentType.JSON).
                and().queryParam("gender", "female").
                and().queryParam("nameContains", "j").
                when().get("/api/spartans/search");


        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));


    }

    @Test
    public void queryParams2Deneme(){

        Map<String, Object> queryParamss= new HashMap<>();
        queryParamss.put("gender", "female");
        queryParamss.put("nameContains", "j");

        Response response = given().accept(ContentType.JSON).
                and().queryParams(queryParamss).
                when().get("api/spartans/search");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));



    }


}
