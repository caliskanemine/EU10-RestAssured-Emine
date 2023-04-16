package com.cybertek.Day7;


import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PutAndPatchDemo extends SpartanTestBase {


    @DisplayName("PUT request to one spartan for update with Map")
    @Test
    public void putRequest(){

        Map<String, Object> putRequestMap= new LinkedHashMap<>();
        putRequestMap.put("name", "BruceWayne");
        putRequestMap.put("gender", "Male");
        putRequestMap.put("phone", 8811111111L);

        given().
                and().contentType(ContentType.JSON).
                body(putRequestMap).log().body().
                and().pathParam("id", 388).
                when().put("/api/spartans/{id}").
        then().statusCode(204);

        //send a get request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send



    }

    @DisplayName("PATCH request to one spartan for partial update with Map")
    @Test
    public void patchRequest(){

        Map<String, Object> putRequestMap= new LinkedHashMap<>();
        putRequestMap.put("phone", 8811111111L);

        given().
                and().contentType(ContentType.JSON).
                body(putRequestMap).log().body().
                and().pathParam("id", 388).
                when().patch("/api/spartans/{id}").
                then().statusCode(204);

        //send a get request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send

    }


    @DisplayName("DELETE one spartan")
    @Test
    public void deleteSpartan(){
        int idToDelete=350;

        given().pathParam("id", idToDelete).
                when().delete("/api/spartan/{id}").
                then().statusCode(204);

        //send a get request after ypu delete make sure you are getting 404


    }



}
