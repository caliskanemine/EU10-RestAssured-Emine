package com.cybertek.ApiShorts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartanSpecBase {

    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we dont need to type each http method
        baseURI = "http://44.197.123.56:8000";
    }

    public RequestSpecification reqSpec= RestAssured.given().accept(ContentType.JSON);

    public ResponseSpecification respSpec= reqSpec.expect().statusCode(200);



}
