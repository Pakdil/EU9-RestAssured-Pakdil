package com.cybertek.ApiShorts.ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SpartanTestWithQueryParams {

    @BeforeClass
    public void setUpClass() {
        baseURI = "http://54.234.104.66:8000";
    }

    @Test
    public void QueryParam1() {

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "J")
                .when().get("/api/spartans/search");
        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(response.contentType(), "application/json");

        Assert.assertTrue(response.body().asString().contains("Female"));

        Assert.assertFalse(response.body().asString().contains("Male"));

        Assert.assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();

    }


    @Test

    public void queryParam2() {
        //creating map for query Params

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("gender", "Female");
        paramsMap.put("nameContains", "J");

        // send request
        Response response = given().accept(ContentType.JSON)
                .and().queryParams(paramsMap)
                .when().get("/api/spartans/search");

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(response.contentType(), "application/json");

        Assert.assertTrue(response.body().asString().contains("Female"));

        Assert.assertFalse(response.body().asString().contains("Male"));

        Assert.assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();


    }


}
