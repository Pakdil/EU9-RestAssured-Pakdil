package com.cybertek.ApiShorts.ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SpartanTestWithPathMethod {

    @BeforeClass
    public void setUpClass() {
        baseURI = "http://54.234.104.66:8000";
    }

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}");

        // verify status code
        assertEquals(response.statusCode(), 200);

        //verify content type
        assertEquals(response.contentType(), "application/json");

        // printing values of json keys
        System.out.println("Id:" + response.body().path("id").toString());
        System.out.println("name:" + response.body().path("name").toString());
        System.out.println("gender:" + response.body().path("gender").toString());
        System.out.println("phone:" + response.body().path("phone").toString());

        int id = response.path("id");
        String name = response.body().path("name");
        String gender = response.body().path("gender");
        long phone = response.body().path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        //verify json keys and values
        assertEquals(id, 10);
        assertEquals(name, "Lorenza");
        assertEquals(gender, "Female");
       assertEquals(phone, 3312820936l);

    }


    @Test
    public void test2() {
        Response response = get("/api/spartans");

        //extracy first id
        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        //extract name
        String first1stName = response.path("name[0]");
        System.out.println("first1stName = " + first1stName);

        // get the last firstname
        String last1stName = response.path("name[-1]");
        System.out.println("last1stName = " + last1stName);

        //extract all firstNames and print them
        List<String> names = response.path("name");
        System.out.println(names);
        System.out.println("names.size() = " + names.size());

        List<Object> phoneNumbers = response.path("phone");
        System.out.println("phoneNumbers = " + phoneNumbers);
        System.out.println("phoneNumbers.size() = " + phoneNumbers.size());

    }
}

