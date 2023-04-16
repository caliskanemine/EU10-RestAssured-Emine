package com.cybertek.Day6;

import com.cybertek.pojo.Employee;
import com.cybertek.pojo.Link;
import com.cybertek.pojo.Region;
import com.cybertek.pojo.Regions;
import com.cybertek.utilities.HrTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ORDSPojoGetRequestTest extends HrTestBase {

    @Test
    public void regionTest(){

        JsonPath jsonPath = get("/regions").
                then().statusCode(200).
                extract().jsonPath();

        Region region1 = jsonPath.getObject("items[0]", Region.class);

        System.out.println("region1 = " + region1);

        System.out.println("region1.getRegion_id() = " + region1.getRID());
        System.out.println("region1.getRegion_name() = " + region1.getRegion_name());
        System.out.println("region1.getLinks().get(0).getHref() = " + region1.getLinks().get(0).getHref());

    }

    @DisplayName("GET request to /employees and only get couple of values as a Pojo class")
    @Test
    public void employeeGet(){

        Employee employee1 = get("/employees").then().statusCode(200).
                extract().jsonPath().getObject("items[0]", Employee.class);

        System.out.println("employee1 = " + employee1);
    }


    /*
     SEND A GET REQUEST TO REGIONS
     verify that region ids are 1,2,3,4
     verify that regions names Europe, Americas, Asia, Middle East and Africa
     verify that count is 4
     try to use pojo as much as possible
     ignore non used fields
     */
    @DisplayName("GET request to region only some fields test")
    @Test
    public void regionPojoTest(){

        Regions regions = get("/regions").
                          then().statusCode(200).
                          extract().as(Regions.class);

        assertThat(regions.getCount(), is(4));

        List<String> regionNames= new ArrayList<>();
        List<Integer> regionIds= new ArrayList<>();
        List<Region> items= regions.getItems();

      /*  for (Region region : regions.getItems()) {

        }

       */

        for (Region region : items) {
            regionIds.add(region.getRID());
            regionNames.add(region.getRegion_name());
        }

        //prepare expected result
        List<Integer> expectedRegionIds= Arrays.asList(1,2,3,4);
        List<String> expectedRegionNames=Arrays.asList("Europe", "Americas", "Asia", "Middle East and Africa");

        //compare two results
        assertThat(regionIds, is(expectedRegionIds));
        assertThat(regionNames, is(equalTo(expectedRegionNames)));





    }


}
