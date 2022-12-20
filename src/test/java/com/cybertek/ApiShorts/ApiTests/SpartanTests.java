package com.cybertek.ApiShorts.ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SpartanTests {

    String spartanBaseUrl = "http://54.234.104.66:8000";

    @Test
    public void viewSpartanTest1() {
        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

        //print the status code
        System.out.println(response.statusCode());

        //print body

        System.out.println(response.body().prettyPrint());
    }
}