package com.cybertek.Day10;

import com.cybertek.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanWithXML extends SpartanAuthTestBase {


    @DisplayName("GET request to /api/spartans and verify xml")
    @Test
    public void getSpartanXML(){

        //we will ask for xml response
        //assert status code 200
        //assert content type is xml
        //verify first spartan name is Meade
         given().accept(ContentType.XML).
                and().auth().basic("admin", "admin").
                when().get("/api/spartans").
                then().statusCode(200).
                contentType("application/xml").
                 body("List.item[0].name", Matchers.is("Meade")).
                 body("List.item[0].gender", Matchers.is("Male")).
                 log().all();


    }

    @Test
    public void getSpartanXMLDeneme(){

        //we will ask for xml response
        //assert status code 200
        //assert content type is xml
        //verify first spartan name is Meade

        given().accept(ContentType.XML).
                and().auth().basic("admin", "admin").
                when().get("/api/spartans").
                then().statusCode(200).
                contentType("application/xml").
                body("List.item[0].name", Matchers.is("Meade")).
                log().all();



    }

    @DisplayName("GET request /api/spartans with xmlPath")
    @Test
    public void testXmlPath(){

        Response response = given().accept(ContentType.XML).
                and().auth().basic("admin", "admin").
                when().get("/api/spartans");


        //get response xml body/payload and save inside the xmlpath object
        XmlPath xmlPath = response.xmlPath();

        String name= xmlPath.getString("list.item[0].name");
        System.out.println("name = " + name);

        int id= xmlPath.getInt("list.item[2].id");
        System.out.println("id = " + id);

        //how to get all names and save into list of strinh
        List<String> listOfNames = xmlPath.getList("List.item.name");
        System.out.println("listOfNames = " + listOfNames);


    }

    @Test
    public void testXmlPathDeneme(){

        Response response = given().accept(ContentType.XML).
                auth().basic("admin", "admin").
                and().when().get("/api/spartans");

        XmlPath xmlPath = response.xmlPath();

        String name = xmlPath.getString("list.item[0].name");
        System.out.println("name = " + name);

        int id=xmlPath.getInt("list.item[2].id");
        System.out.println("id = " + id);

        List<String> listOfNames = xmlPath.getList("list.item.name");
        System.out.println("listOfNames = " + listOfNames);

    }



}
