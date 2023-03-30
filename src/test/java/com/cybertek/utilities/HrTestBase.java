package com.cybertek.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class HrTestBase {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method
         baseURI = "http://44.197.123.56:1000/ords/hr";
    }

    /*
     //get ip address from configuraitons
    String dbUrl = "jdbc:oracle:thin:@44.197.123.56:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);

     */


}
