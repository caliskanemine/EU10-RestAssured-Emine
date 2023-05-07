package com.cybertek.Day12;

import com.cybertek.utilities.SpartanNewBase;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class OldRestAssuredTest extends SpartanNewBase {

    @Test
    public void getAllSpartan(){

        given().accept(ContentType.JSON).
                and().auth().basic("admin", "admin").
                log().all().
                when().get("/spartans").
                then().statusCode(200).
                contentType(ContentType.JSON).
                body("id[0]", is(1)).
                body("id[5]", is(199)).
                log().all();
    }

    @Test
    public void test2(){

        /*
        in previous version of RestAssured, the given when then style
        was actually written in given expact when format
         */

        given().accept(ContentType.JSON).
                and().auth().basic("admin", "admin").
                log().all().
                expect().statusCode(200).
                and().contentType(ContentType.JSON).
                body("id[0]", is(1)).
                logDetail(LogDetail.ALL).
                when().get("/spartans");

    }


}
