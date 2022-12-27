package com.cybertek.ApiShorts.ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestWithHamcrest {

   @BeforeClass
    public void setUpClass() {
       baseURI="http://54.234.104.66:8000";
   }

   /*
   given accept type is json
   And path param id is 15
   When user sends a get request to spartans/{id}
   Then status cod is 200
   And content type is Json
   And json data has following

   "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": 1938695106

    */

   @Test
    public void test1() {
     given().accept(ContentType.JSON)
               .pathParam("id", 15)
               .when().get("api/spartans/{id}")
               .then().statusCode(200).and()    // send request
               .assertThat().contentType("application/json");  // response

   }

   @Test
    public void test2() {
       given().accept(ContentType.JSON)
               .pathParam("id", "15")
               .when().get("api/spartans/{id}")
               .then().assertThat().statusCode(200)
               .and().assertThat().contentType("application/json")
               .and().assertThat().body("id", equalTo(15), "name",equalTo("Meta"),
               "gender", equalTo("Female"), "phone", equalTo(1938695106));
   }



}
