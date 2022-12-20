package com.cybertek.ApiShorts.ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestWithPathParameters {

    @BeforeClass
    public void setUpClass() {
        RestAssured.baseURI="http://54.234.104.66:8000";
    }

    @Test
    public void PathTest1() {

       Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParams("id", 18)
               .when().get("api/spartans/{id}");

        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json");

        assertTrue(response.body().asString().contains("Allen"));
        response.body().prettyPrint();

    }

    /*
    Given accept type is Json
    And I parameter value is 500
    When user sends Get request to /api/spartans/{id}
    Then response tatus cod should be 404
    And response content-type: application/json；charset=UT-8
    And "Spartan Not Found" message should be in response payload
     */


    @Test
    public void negativePathParamTest() {

       Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParams("id", 500)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(), 404);

        assertEquals(response.contentType(), "application/json");

        assertTrue(response.body().asString().contains("Not Found"));

        response.prettyPrint();
    }
}
