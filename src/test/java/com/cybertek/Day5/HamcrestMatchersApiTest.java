package com.cybertek.Day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestMatchersApiTest {

    /*
       given accept type is Json
       And path param id is 15
       When user sends a get request to spartans/{id}
       Then status code is 200
       And content type is Json
       And json data has following
           "id": 15,
           "name": "Meta",
           "gender": "Female",
           "phone": 1938695106
        */


    @DisplayName("OneSpartan with Hamcrest and chaining")
    @Test
    public void test1(){

            given().
                    accept(ContentType.JSON).
            and().pathParam("id", 15).
            when().
                    get("http://44.197.123.56:8000/api/spartans/{id}"). //buraya kadar request, burdan sonra response
            then().
                    statusCode(200).
                    and().assertThat().
                    contentType("application/json").
                    and().
                    body("id", equalTo(15),
                            "name", is("Meta"),
                            "gender", is("Female"),
                            "phone", is(1938695106));
}

    @DisplayName("CBTraining Teavcher request with chaining and matchers")
    @Test
    public void teacherData(){

        given().accept(ContentType.JSON).and().pathParam("id", 3).
                when().get("https://api.training.cydeo.com/teacher/{id}").
                then().
                statusCode(200).
                and().contentType("application/json;charset=UTF-8").
                and().header("Date",notNullValue()).and().assertThat().
                body("teachers[0].firstName", is("Tet")).
                body("teachers[0].lastName", is("DS")).
                body("teachers[0].gender", equalTo("Male"));
    }

    @DisplayName("GET request to teacher/all and chaining")
    @Test
    public void teachersTest(){

        given().accept(ContentType.JSON).
                when().get("https://api.training.cydeo.com/teacher/{id}").
                then().statusCode(200).
                and().body("teachers.firstName",hasItems("Valter","Mario","Porter"));

    }


}
