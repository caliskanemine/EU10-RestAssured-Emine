package com.cybertek.Day10;

import com.cybertek.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class JsonSchemaValidationTest extends SpartanAuthTestBase {

    @DisplayName("GET request to verify one spartan against to schema")
    @Test
    public void schemaValidation(){

        given().accept(ContentType.JSON).
                and().pathParam("id", 10).
                and().auth().basic("admin", "admin").
                when().get("/api/spartans/{id}").
                then().statusCode(200).
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json")).
                log().all();
    }

    @DisplayName("GET request to all spartans and verify schema")
    @Test
    public void allSpartanSchemaTest(){


        given().accept(ContentType.JSON).
        and().auth().basic("admin", "admin").
        when().get("/api/spartans").
                then().statusCode(200).
                //what if you have your file not under resources following way:
                body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/com/cybertek/Day10/allSpartansSchema.json.url")));



    }


}
