package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestWithJsonPath extends SpartanTestBase {



      /*
    given accept type is json
    And path param id is 11
    when user sends a get request to "/api/spartans/{id}"
    then status code is 200
    and content type is "application/json
    and response payload values match the following:
    id is 11
    name is "Lorenza"
    gender is "Female"
    phone is 3312820938
     */
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).
                pathParam("id", 11).
                when().get("/api/spartans/{id}");

        assertEquals(200, response.statusCode());

        int id= response.path("id");
        System.out.println("id = " + id);

        //how to read value with jsonPath
        JsonPath jsonData = response.jsonPath();

        int id1 = jsonData.getInt("id");
        String name= jsonData.getString("name");
        String gender = jsonData.getString("gender");
        long phone = jsonData.getLong("phone");


        System.out.println("id1 = " + id1);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        assertEquals(11, id);
        assertEquals("Nona", name);
        assertEquals("Female", gender);
        assertEquals(7959094216l, phone);




    }


    @Test
    public void test1Deneme(){

        Response response = given().accept(ContentType.JSON).
                and().pathParam("id", 11).
                when().get("/api/spartans/{id}");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());

        JsonPath jsonPath= response.jsonPath();

        int id = jsonPath.getInt("id");
        String name= jsonPath.getString("name");
        String gender = jsonPath.getString("gender");
        long phone= jsonPath.getLong("phone");

        assertEquals(11, id);
        assertEquals("Nona", name);
        assertEquals("Female", gender);
        assertEquals(7959094216l, phone);


    }


}
