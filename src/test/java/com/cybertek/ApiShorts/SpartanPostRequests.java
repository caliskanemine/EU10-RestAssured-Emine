package com.cybertek.ApiShorts;

import com.cybertek.pojo.PojoSpartanShortDeneme;
import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanPostRequests extends SpartanTestBase {


    @Test
    public void postWithString(){

        Response response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                body("{\n" +
                        "  \"gender\": \"Male\",\n" +
                        "  \"name\": \"Mike\",\n" +
                        "  \"phone\": 2025478854\n" +
                        "}").
                when().post("/api/spartans");

        response.prettyPrint();

        //validations
        //verify status code is 201
        assertEquals(201, response.statusCode());
        assertEquals("application/json", response.contentType());

        //verify success message
        assertEquals("A Spartan is Born!", response.path("success"));

        //verify request body
        JsonPath json= response.jsonPath();

        assertEquals("Mike", json.getString("data.name"));
        assertEquals("Male", json.getString("data.gender"));
        assertEquals(2025478854L, json.getLong("data.phone"));


    }

    @Test
    public void postWithStringDeneme(){

        Response response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                body("{\n" +
                        "  \"gender\": \"Female\",\n" +
                        "  \"name\": \"Emine\",\n" +
                        "  \"phone\": 5454656564\n" +
                        "}").
                when().post("api/spartans");

        response.prettyPrint();

        assertEquals(201, response.statusCode());
        assertEquals("application/json", response.contentType());

        //verify success message
        assertEquals("A Spartan is Born!", response.path("success"));

        JsonPath json= response.jsonPath();

        assertEquals("Emine", json.getString("data.name"));
        assertEquals("Female", json.getString("data.gender"));
        assertEquals(5454656564l, json.getLong("data.phone"));
    }


    @Test
    public void postMethodWithMap(){

        //create a map to be used as a body for post request
        Map<String, Object> requestMap= new HashMap<>();
        requestMap.put("name", "MikeMap");
        requestMap.put("gender", "Male");
        requestMap.put("phone", 2025478854L);

        Response response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                body(requestMap).
                when().post("/api/spartans");

        assertEquals(201, response.statusCode());
        assertEquals("application/json", response.contentType());

        response.prettyPrint();

        assertEquals("A Spartan is Born!", response.path("success"));

    }

    @Test
    public void postMethodWithMapDeneme(){

        Map<String, Object> jsonBody= new HashMap<>();
        jsonBody.put("id", 118);
        jsonBody.put("name", "MikeMap");
        jsonBody.put("gender", "Male");
        jsonBody.put("phone", 2025478854l);


        Response response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(jsonBody).
                when().post("/api/spartans");

        response.prettyPrint();

        assertEquals(201, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertEquals("A Spartan is Born!", response.path("success"));

        JsonPath json= response.jsonPath();

        assertEquals("MikeMap", json.getString("data.name"));
        assertEquals("Male", json.getString("data.gender"));
        assertEquals(2025478854l, json.getLong("data.phone"));
    }

    @Test
    public void postWithPojo(){

        //create Spartan object and use as a body for post request
        PojoSpartanShortDeneme pojoSpartanShortDeneme=new PojoSpartanShortDeneme();
        pojoSpartanShortDeneme.setName("MikePojo");
        pojoSpartanShortDeneme.setGender("Male");
        pojoSpartanShortDeneme.setPhone(5412312312L);

        Response response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                body(pojoSpartanShortDeneme).
                when().post("/api/spartans");

        response.prettyPrint();

        assertEquals(201, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertEquals("A Spartan is Born!", response.path("success"));

        JsonPath data= response.jsonPath();

        assertEquals("MikePojo", data.getString("data.name"));
        assertEquals("Male", data.getString("data.gender"));
        assertEquals(5412312312l, data.getLong("data.phone"));

        //GET REQUEST
        Response response2 = given().accept(ContentType.JSON).
                pathParam("id", 107).
                and().when().get("/api/spartans/{id}");

        PojoSpartanShortDeneme pojoResponse = response2.body().as(PojoSpartanShortDeneme.class);

        System.out.println(pojoResponse.toString());


    }

}
