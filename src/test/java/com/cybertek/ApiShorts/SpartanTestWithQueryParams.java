package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;

public class SpartanTestWithQueryParams extends SpartanTestBase {


    /*
    Given accept type is Json
    And query parameter values are:
    gender/female
    nameContains/e
    When user sends GET request to /api/spartans/search
    Then response status code should be 200
    And response content-type: applicaiton/json
    And "Female" should be in response payload
    And "Janetta" should be in response payload
     */

}
