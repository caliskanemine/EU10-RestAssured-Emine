package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestWithPathMethod extends SpartanTestBase {


/*
        given accept type is json
        And path param id is 10
        when user sends a get request to "/api/spartans/{id}"
        then status code is 200
        and content type is "application/json
        and response payload values match the following:
        id is 10
        name is "Lorenza"
        gender is "Female"
        phone is 3312820938
 */
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).
                pathParam("id", 10).
                when().get("/api/spartans/{id}");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());

        //printing values of json keys
        System.out.println("ID: "+ response.body().path("id").toString());
        System.out.println("Name: "+ response.body().path("name").toString());
        System.out.println("Gender: "+ response.body().path("gender").toString());
        System.out.println("Phone: "+ response.body().path("phone").toString());

        int id=response.path("id");
        String name= response.path("name");
        String gender= response.body().path("gender");
        long phone= response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        //verify json keys and values
        assertEquals(10, id);
        assertEquals("Lorenza", name);
        assertEquals("Female", gender);
        assertEquals(3312820936l, phone);


    }

    @Test
    public void test1Deneme(){


        Response response = given().accept(ContentType.JSON).
                and().pathParam("id", 10).
                when().get("/api/spartans/{id}");

        assertEquals(200,response.statusCode());
        assertEquals("application/json", response.contentType());

       int id= response.body().path("id");
       String name= response.body().path("name");
       String gender= response.body().path("gender");
       long phone= response.body().path("phone");

       assertEquals(10, id);
       assertEquals("Lorenza", name);
       assertEquals("Female", gender);
       assertEquals(3312820936l, phone);

    }


    @Test
    public void test2(){

        Response response = when().get("/api/spartans");

        //extract first id
        int firstId= response.path("id[0]");

        System.out.println("firstId = " + firstId);

        //extract name
        String firstName= response.path("name[0]");
        System.out.println("firstName = " + firstName);

        //get the lastfirst name
        String last1stName= response.path("name[-1]");
        System.out.println("last1stName = " + last1stName);

        //extract all firstNames and print them
        List<String> names= response.path("name");
        System.out.println(names);
        System.out.println("names size= " + names.size());

        for (String eachName : names) {
            System.out.print(" "+eachName);
        }
        System.out.println();

        List<Object> phone= response.path("phone");
        for (Object eachPhone : phone) {
            System.out.print(" - "+eachPhone);
        }



    }








}
