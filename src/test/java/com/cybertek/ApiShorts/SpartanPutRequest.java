package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class SpartanPutRequest extends SpartanTestBase {


    @Test
    public void putRequest(){

        //Different ways to send json body
        //-string
        //-using collection(map)
        //-POJO

         //using map
        //we gonna send request body with updated value, and content type header

        Map<String, Object> putMaps= new HashMap<>();
        putMaps.put("name", "Jack");
        putMaps.put("gender", "Male");
        putMaps.put("phone", 3239745457l);


         given().contentType(ContentType.JSON).
                and().pathParam("id", 101).
                and().body(putMaps).
                when().put("/api/spartans/{id}").
                 then().assertThat().statusCode(204);


    }

    @Test
    public void putRequestDeneme(){


        Map<String, Object> myBody= new HashMap<>();
        myBody.put("name", "Jack");
        myBody.put("gender", "Male");
        myBody.put("phone", 3239745457l);

        given().contentType(ContentType.JSON).
                and().pathParam("id", 101).
                and().body(myBody).
                when().put("/api/spartans/{id}").
                then().assertThat().statusCode(204);


    }

    @Test
    public void patchRequest(){

        Map<String, Object> patchBody= new HashMap<>();
        patchBody.put("name", "JackPATCH");

        given().contentType(ContentType.JSON).
                and().pathParam("id", 101).
                and().body(patchBody).
                when().patch("/api/spartans/{id}").
                then().assertThat().statusCode(204);

    }


}
