package com.cybertek.Day4;

import com.cybertek.utilities.HrTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath extends HrTestBase{

    @DisplayName("GET request to Countries")
    @Test
    public void test1(){

        Response response = get("/countries");

        //get the second country name with JsonPath

        //to use JsonPath we assign response to JsonPath
        JsonPath jsonPath = response.jsonPath();

        String secondCountryName= jsonPath.getString("items[1].country_name");

        System.out.println("secondCountryName = " + secondCountryName);

        //get all country ids
        //items.country_id
        // List<String> allCountryIds= jsonPath.getList("items.country_id"); //getList hata veriyor!!!

        //  System.out.println("allCountryIds = " + allCountryIds);


        //get all country names where their region id is equal to 2
        List<String> countryNamesWithRegionId2= jsonPath.getList("items.findAll{it.region_id==2}.country_name");
        System.out.println(countryNamesWithRegionId2);
    }


    @DisplayName("GET request /employees with query param")
    @Test
    public void test2(){

                Response response = given().queryParam("limit", 107).
                when().get("/employees");

        //get me all email of employees who is working as IT_PROG
        JsonPath jsonPath = response.jsonPath();

        List<String> employeeITProgs = jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");

        System.out.println(employeeITProgs);

        //get me first_name of employees who is making more than 10000
        List<String> firstNames = jsonPath.getList("items.findAll {it.salary>10000}.first_name");
        System.out.println(firstNames);


        //get max salary first_name
        String kingFirstName= jsonPath.getString("items.max{it.salary}.first_name");
        String kingsNameWithPathMethod = response.path("items.max{it.salary}.first_name");
        System.out.println("kingFirstName = " + kingFirstName);
        System.out.println("kingsNameWithPathMethod = " + kingsNameWithPathMethod);






    }

}
