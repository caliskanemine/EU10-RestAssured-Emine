package com.cybertek.ApiShorts;

import com.cybertek.utilities.SpartanTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanDeleteRequest extends SpartanTestBase {

      @Test
    public void test1(){

          given().pathParam("id",125).
                  when().delete("/api/spartans/{id}").
                  then().assertThat().statusCode(204); //delete işlemi 204, verifydan sonra gelmesi gereken 404.ilk defa ikisini birlikte çalıştırırsan hata vermez!!

          //verify part
          given().pathParam("id",125).
                  when().delete("/api/spartans/{id}").
                  then().assertThat().statusCode(404);



      }

      @Test
    public void test1Deneme(){

          given().pathParam("id", 127).
                  when().delete("/api/spartans/{id}").
                  then().assertThat().statusCode(204);

          given().pathParam("id", 127).
                  when().delete("/api/spartans/{id}").
                  then().assertThat().statusCode(404);


      }

}
