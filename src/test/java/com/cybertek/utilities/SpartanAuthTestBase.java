package com.cybertek.utilities;


import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartanAuthTestBase {

    @BeforeAll
    public static void init(){

     baseURI= "http://44.197.123.56:7000";

    }



}
