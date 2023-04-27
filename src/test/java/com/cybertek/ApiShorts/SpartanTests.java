package com.cybertek.ApiShorts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpartanTests {


    String spartansBaseUrl= "http://44.197.123.56:8000";

    @Test
    public void viewSpartanTest1(){

        Response response = RestAssured.get(spartansBaseUrl + "/api/spartans");

        System.out.println("StatusCode: " + response.statusCode());

        System.out.println("Response Body: " + response.body().asString());

        System.out.println(response.body().prettyPrint()); //asString ya da prettyPrint olarak yapabilirz; prettyPrint postmandaki gibi getiriyor sonucu, o yüzden yanına string olarak "Response body" yazdığımızda onu okumuyor, sadece veriyi getiriyor


    }

    @Test
    public void viewSpartanTest1Deneme() {
        Response response = RestAssured.get(spartansBaseUrl + "/api/spartans");
        System.out.println("statusCode = " + response.statusCode());
        System.out.println(response.body().prettyPrint());

    }

    @Test
    public void viewSpartanTest2(){

        Response response = RestAssured.get(spartansBaseUrl + "/api/spartans");

       assertEquals(200, response.statusCode());

        //verify body contains Allen
        assertTrue(response.body().asString().contains("Allen"));
        System.out.println(response.body().asString().contains("Allen"));
        // --sout yaparsak true ya da false olarak sonuç verir, assert sadece pass ya da fail sonucu gönderir, fail olunca expected ve actual true false olarak sonucu gönderir.

    }

    //given accept type is json
    //when user sends a get request to spartanAllUrl
    //then response status code is 200
    //and response body should be json format
    @Test
    public void viewSpartanTest3(){

        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(spartansBaseUrl + "/api/spartans");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        response.prettyPrint();


    }

    @Test
    public void viewSpartanTest3Deneme(){

        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(spartansBaseUrl + "/api/spartans");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());

        System.out.println("Response contentType = " + response.contentType());


    }






}
