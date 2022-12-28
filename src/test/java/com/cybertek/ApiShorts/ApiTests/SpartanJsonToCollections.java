package com.cybertek.ApiShorts.ApiTests;

import static org.testng.Assert.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SpartanJsonToCollections {

    @BeforeClass
    public void setUpClass() {
        baseURI = "http://54.234.104.66:8000";
    }

    /*
    And json data has following
     "id": 11,
    "name": "Nona",
    "gender": "Female",
    "phone": 7959094216
     */

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .and().when().get("/api/spartans/{id}");

        // convert Json response to Java Collections (Map)
      Map<String, Object> spartanMap =  response.body().as(Map.class);

        System.out.println(spartanMap.get("name"));
        System.out.println(spartanMap.get("id"));

        assertEquals(spartanMap.get("name"), "Nona");

    }


}
