package com.cybertek.Day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class SpartanTestsWithParameters {

    /*
        import static io.restassured.RestAssured.*;
        import static org.junit.jupiter.api.Assertions.*;

        bu ikisini her zmaan import bölümüne copy paste yap otomatik kullan
         */


    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method
        baseURI= "http://44.197.123.56:8000";
    }


     /*   Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Blythe" should be in response payload(body)
       */

    @DisplayName("GET request to /epi/spartans/{id} with ID 5")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).
                            and().pathParam("id", 5).
                            when().get("/api/spartans/{id}");


        assertEquals(200, response.statusCode());

        assertEquals("application/json", response.contentType());

       assertTrue(response.body().asString().contains("Blythe"));
    }

    /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */


    @DisplayName("GET request to /api/spartans/{id} Negative Test")
    @Test
    public void test2(){

        Response response= given().accept(ContentType.JSON).
                pathParam("id", 500).
                when().get("/api/spartans/{id}");//get hata veriyor

        assertEquals(404, response.statusCode());

        assertEquals("application/json", response.contentType());

        assertTrue(response.body().asString().contains("Not Found"));

    }

    /*
        Given accept type is Json
        And query parameter values are:
        gender|Female
        nameContains|e
        When user sends GET request to /api/spartans/search
        Then response status code should be 200
        And response content-type: application/json
        And "Female" should be in response payload
        And "Janette" should be in response payload
     */
     @DisplayName("GET request to /api/spartans/search")
     @Test
     public void test3(){

         Response response = given().log().all().accept(ContentType.JSON).  //log().all() run bölümüne detayları getiriyor, all yerine örneğin parameters() dersek sadece parameter detaylarını getirir
                 and().queryParam("nameContains", "e").
                 and().queryParam("gender", "Female").
                 when().get("/api/spartans/search");

         assertEquals(200, response.statusCode());

         assertEquals("application/json", response.contentType());

         assertTrue(response.body().asString().contains("Female"));

         assertTrue(response.body().asString().contains("Janette"));

     }

    @DisplayName("GET request to /api/spartans/search with Query Params {MAP}")
    @Test
    public void test4(){
         
                //create a map and add query parameters
                Map<String, Object> queryMap= new HashMap<>();
                queryMap.put("nameContains", "e");
                queryMap.put("gender", "Female");

                Response response= given().log().all().accept(ContentType.JSON).
                and().queryParams(queryMap).
                when().get("/api/spartans/search");

                assertEquals(200, response.statusCode());

                assertEquals("application/json", response.contentType());

        assertTrue(response.body().asString().contains("Female"));

        assertTrue(response.body().asString().contains("Janette"));


    }










    }
