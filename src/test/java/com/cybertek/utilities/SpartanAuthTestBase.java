package com.cybertek.utilities;


import static io.restassured.RestAssured.baseURI;

public class SpartanAuthTestBase {

    public static void init(){

     baseURI= "http://44.197.123.56:7000";

    }



}
