package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review4 extends SpartanTestBase {

    /*
    we have 4 ways to provide data to test
    1-value source
    2-method source
    3-csv source
    4-csv file source
     */


    @ParameterizedTest
    @ValueSource(ints = {4,6,7,8,9})
    @Test
    public void valueSource(int id){

        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get("/api/spartans/"+id);

        response.prettyPrint();
    }


    @ParameterizedTest
    @ValueSource(ints = {3,4,9,1,15})
    @Test
    public void test1Deneme(int ids){

        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get("/api/spartans/" + ids);
        response.prettyPrint();
    }


    public List<String> getPartialNames(){
        List<String> names= Arrays.asList("va", "ma", "de", "nu");
        return names;
    }

    @ParameterizedTest
    @MethodSource("getPatialNames")  //you have to create a method first
    @Test
    public void methodSource(String names){

        Response response = RestAssured.given().accept(ContentType.JSON).
                and().queryParam("nameContains", names).
                when().get("api/spartans/search");
        response.prettyPrint();

    }

    public List<String> names(){
        List<String> partials= Arrays.asList("va", "me", "de", "nu");
        return partials;
    }

    @ParameterizedTest
    @MethodSource("names")
    @Test
    public void methodSourceDeneme(String names){
        Response response = RestAssured.given().accept(ContentType.JSON).
                and().queryParam("nameContains", names).
                when().get("/api/spartans/searc");
        response.prettyPrint();
    }


    @ParameterizedTest
    @CsvSource({"8,Rodolfo",
                "13,Jaimie",
                "21,Mark"})
    @Test
    public void csvSource(int id, String name){
        Response response = RestAssured.given().accept(ContentType.JSON).
                pathParam("id", id).
                when().get("/api/spartans/{id}");

        Assertions.assertEquals(name, response.path("name"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "SpartanDataPOST.csv", numLinesToSkip = 1)
    @Test
    public void csvFileSource(String name, String gender, Long phone){

        Map<String, Object> body= new HashMap<>();
        body.put("name", name);
        body.put("gender", gender);
        body.put("phone", phone);

        Response response= RestAssured.given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(body).
                when().post("/api/spartans");
        response.prettyPrint();

    }




}
