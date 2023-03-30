package com.cybertek.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartanTestBase {


    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method
        baseURI= "http://44.197.123.56:8000";
    }

   /*
    String dbUrl = "jdbc:oracle:thin:@44.197.123.56:1521:xe";
    String dbUsername = "SP";
    String dbPassword = "SP";

    //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);

    */



}
