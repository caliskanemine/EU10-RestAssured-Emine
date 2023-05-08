package com.cybertek.ApiShorts;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SpecTest extends SpartanSpecBase{

    @Test
    public void test1(){

        Response response= RestAssured.given().spec(reqSpec).
                when().get("/api/spartans").
                then().spec(respSpec).extract().response();
        response.prettyPrint();

    }
}
