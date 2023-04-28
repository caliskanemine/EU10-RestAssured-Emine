package com.cybertek.ApiShorts;

import com.cybertek.pojo.PojoSpartanShortDeneme;
import com.cybertek.pojo.Spartan;
import com.cybertek.utilities.SpartanTestBase;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestPOJODeserilization extends SpartanTestBase {

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).
                and().pathParam("id", 15).
                when().get("/api/spartans/{id}");

       // response.prettyPrint();

       //how to convert json response to our spartan class
        PojoSpartanShortDeneme spartan1= response.body().as(PojoSpartanShortDeneme.class);

       // System.out.println(spartan1.toString());

        //verify each spartan with key object
        assertEquals("Meta", spartan1.getName());
        assertEquals(15, spartan1.getId());
        assertEquals("Female", spartan1.getGender());
        assertEquals(new Long(1938695106), spartan1.getPhone());

    }

    @Test
    public void test1Deneme(){


        Response response = given().accept(ContentType.JSON).
                and().pathParam("id", 15).
                when().get("/api/spartans/{id}");

        PojoSpartanShortDeneme spartan2= response.body().as(PojoSpartanShortDeneme.class);

        assertEquals(15, spartan2.getId());
        assertEquals("Meta", spartan2.getName());
        assertEquals("Female", spartan2.getGender());
        assertEquals(new Long(1938695106), spartan2.getPhone()); // !!!!long lazarken new long olarak kullandık !!!
    }

    @Test
    public void gsonExample(){

        Gson gson= new Gson();

        String myJsonBody= "{\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106\n" +
                "}";

        //using gson method to do deserialize our json body
        PojoSpartanShortDeneme spartan3= gson.fromJson(myJsonBody, PojoSpartanShortDeneme.class);

        System.out.println(spartan3.toString());


        //serialization Java object---> JSON BODY
        PojoSpartanShortDeneme newSpartan= new PojoSpartanShortDeneme(101, "Mike", "Male", 321342123l );

        //converting custom class to json
        String jsonBody= gson.toJson(newSpartan);

        System.out.println(jsonBody);

    }

    @Test
    public void gsonExampleDeneme(){

        Gson gson= new Gson();

        String jsonBody="{\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106\n" +
                "}";

        PojoSpartanShortDeneme newSpa= gson.fromJson(jsonBody, PojoSpartanShortDeneme.class);

        System.out.println(newSpa.toString());

        PojoSpartanShortDeneme newwSpa= new PojoSpartanShortDeneme(101, "Mike", "Male", 34467453753l);

        String jsonBodyy= gson.toJson(newwSpa);

        System.out.println(jsonBodyy.toString());


    }




}
