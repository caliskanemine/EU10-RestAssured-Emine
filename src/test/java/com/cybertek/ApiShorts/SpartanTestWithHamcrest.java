package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestWithHamcrest extends SpartanTestBase{

    /*
     given accept type is json
    And path param id is 15
    when user sends a get request to "/api/spartans/{id}"
    then status code is 200
    and content type is "application/json
    and jsondata has following:
    id is 15
    name is "Meta"
    gender is "Female"
    phone is 1938695106
     */
    @Test
    public void test1(){

        //request- we are going to chain it with response assertion part
                given().accept(ContentType.JSON).
                and().pathParam("id", 15).
                when().get("/api/spartans/{id}").
                then().statusCode(200).  //response part starts here
                and().assertThat().contentType("application/json");

    }

    @Test
    public void test1Deneme(){

        given().accept(ContentType.JSON).
                and().pathParam("id", 15).
                when().get("/api/spartans/{id}").
                then().statusCode(200).
                and().assertThat().contentType("application/json");


    }

    @Test
    public void test2(){

        given().accept(ContentType.JSON).
                and().pathParam("id", 15).
                when().get("/api/spartans/{id}").
                then().assertThat().statusCode(200).
                and().assertThat().contentType("application/json").
                and().assertThat().body("id", Matchers.equalTo(15), "name", Matchers.equalTo("Meta"), "gender",Matchers.equalTo("Female"), "phone" ,Matchers.equalTo(1938695106));
        //matchersı import bölümünde static yapıp, bu bölümde yazmadan direk equalTo ile kullanabilirsin!!

    }

    @Test
    public void test2Deneme(){

        given().accept(ContentType.JSON).
                and().pathParam("id", 15).
                when().get("/api/spartans/{id}").
                then().assertThat().statusCode(200).
                and().assertThat().contentType("application/json").
                and().body("id", Matchers.equalTo(15), "name", Matchers.equalTo("Meta"), "gender", Matchers.equalTo("Female"), "phone", Matchers.equalTo(1938695106));

    }





}
