package com.cybertek.Day10;

import com.cybertek.utilities.SpartanAuthTestBase;
import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ResponseTimeTest extends SpartanTestBase {


    @Test
    public void test1(){

        Response response = given().auth().basic("admin", "admin").
                accept(ContentType.JSON).
                when().get("/api/spartans").
                then().
                extract().response();

        System.out.println("response.getTime() = " + response.getTime());



    }

}
