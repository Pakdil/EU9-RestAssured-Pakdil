package com.cybertek.ApiShorts.ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestWithHamcrest {

   @BeforeClass
    public void setUpClass() {
       baseURI="http://54.234.104.66:8000";
   }

   @Test
    public void test1() {
     given().accept(ContentType.JSON)
               .pathParam("id", 15)
               .when().get("api/spartans/{id}")
               .then().statusCode(200).and()
               .assertThat().contentType("application/json");


   }



}
