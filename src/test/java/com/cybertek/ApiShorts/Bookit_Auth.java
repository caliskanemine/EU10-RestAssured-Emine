package com.cybertek.ApiShorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Bookit_Auth {

    @Test
    public void test1(){

        String url="https://cybertek-reservation-api-qa3.herokuapp.com";

        String accessToken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4NiIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.lEfjcu6RpBfcZ4qWthzZU8uH8fX4FCJFfxBnPNgh4Mo";

        Response response = given().header("Authorization", accessToken).
                when().get(url + "/api/campuses");

        assertEquals(200, response.statusCode());
        response.prettyPrint();


    }


    @Test
    public void test1Deneme(){

        String url="https://cybertek-reservation-api-qa3.herokuapp.com";
        String accessToken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4NiIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.lEfjcu6RpBfcZ4qWthzZU8uH8fX4FCJFfxBnPNgh4Mo";

        Response response = given().header("Authorization", accessToken).
                when().get(url + "/api/campuses");

        assertEquals(200, response.statusCode());
        response.prettyPrint();

    }


}
