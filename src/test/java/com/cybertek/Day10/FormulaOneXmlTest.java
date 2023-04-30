package com.cybertek.Day10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class FormulaOneXmlTest {

    @BeforeAll
    public static void setup() {

        baseURI = "http://ergast.com";
        basePath = "/api/f1";
    }

    @Test
    public void test1(){

        Response response = given().pathParam("driver", "alonso").
                when().get("/drivers/{driver}").
                then().statusCode(200).
                log().all().
                extract().response();

        //get given name
        //get family name
        //get id
        //get code
        //get url

        XmlPath xmlPath = response.xmlPath();

        String givenName = xmlPath.getString("MrData.DriverTable.Driver.GivenName");
        String familyName = xmlPath.getString("MrData.DriverTable.Driver.FamilyName");
        String driverID= xmlPath.getString("MrData.DriverTable.Driver.@driverId");  //if we are trying to get attribute be use @sign!!!
        String code= xmlPath.getString("MrData.DriverTable.Driver.@code") ;
        String url=xmlPath.getString("MrData.@url");

        System.out.println("givenName = " + givenName);
        System.out.println("familyName = " + familyName);
        System.out.println("driverID = " + driverID);
        System.out.println("code = " + code);
        System.out.println("url = " + url);
    }

    @Test
    public void test1Deneme(){

        Response response = given().pathParam("driver", "alonso").
                when().get("/drivers/{driver}").
                then().statusCode(200).
                log().all().
                extract().response();

        XmlPath xmlPath = response.xmlPath();

        //get given name
        //get family name
        //get id
        //get code
        //get url

        String givenName = xmlPath.getString("MrData.DriverTable.Driver.GivernName");
        String familyName= xmlPath.getString("MrData.DriverTable.Driver.FamilyName");
        String id=xmlPath.getString("MrData.DriverTable.@driverId");
        String code= xmlPath.getString("MrData.DriverTable.Driver.@code");
        String url= xmlPath.getString("MrData.@url");

        System.out.println("givenName = " + givenName);
        System.out.println("familyName = " + familyName);
        System.out.println("id = " + id);
        System.out.println("code = " + code);
        System.out.println("url = " + url);

    }


}
