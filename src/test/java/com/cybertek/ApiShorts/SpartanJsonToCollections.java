package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanJsonToCollections extends SpartanTestBase {


    /*
    Given accept type is json
    And path param spartan id is 11
    When user sends a get request to /spartans/{id}
    Then status code is 200
    And content type is Json
    And "id" : 11,
    "name" : "Nona",
    "gender": "Female",
    "phone": 7959094216
     */
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).
                and().pathParam("id", 11).
                and().when().get("/api/spartans/{id}");

        //convert Json response to Java Collections(Map)
        Map <String, Object> spartanMap = response.body().as(Map.class);

        System.out.println(spartanMap.get("name"));
        System.out.println(spartanMap.get("id"));

        //one example verification on side map/ expected value
        assertEquals( "Nona", spartanMap.get("name"));


    }

    @Test
    public void test1Deneme(){

        Response response = given().accept(ContentType.JSON).
                and().pathParam("id", 11).
                when().get("/api/spartans/{id}");

        Map<String, Object> myMap = response.body().as(Map.class);

        System.out.println("myMap.get(\"id\") = " + myMap.get("id"));
        System.out.println("myMap.get(\"name\") = " + myMap.get("name"));

        assertEquals(11, myMap.get("id"));
        assertEquals("Nona", myMap.get("name"));

    }

    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON).
                when().get("/api/spartans");

        //response.prettyPrint();

        //convert full json body to list of maps
        List<Map<String,Object>> listOfSpartans = response.body().as(List.class);



        //print all data of first spartan
        System.out.println("listOfSpartans.get(0) = " + listOfSpartans.get(0));

        Map<String, Object> firstSpartan= listOfSpartans.get(0);
        System.out.println(firstSpartan);

        System.out.println("firstSpartan.get(\"name\") = " + firstSpartan.get("name"));

        int counter=1;
        for (Map<String, Object> map : listOfSpartans) {  // iter yaz+enter-> en altta çıkana tıkla
            System.out.println(counter+" -spartan "+ map);
            counter++;
        }


    }

    @Test
    public void test2Deneme(){

        Response response = given().accept(ContentType.JSON).
                when().get("/api/spartans");
        //response.prettyPrint();

        List<Map<String, Object>> myMapp = response.body().as(List.class);

        System.out.println("myMapp.get(0) = " + myMapp.get(0));

        Map<String, Object> firstMap= myMapp.get(0);

        System.out.println("firstMap = " + firstMap);

        int count=1;
        for (Map<String, Object> eachMap : myMapp) {
            System.out.println(count+"= "+eachMap);
            count++;
        }
        System.out.println(count-1);


    }


}
