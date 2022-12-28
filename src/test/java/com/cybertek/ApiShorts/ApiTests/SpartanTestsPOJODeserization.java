package com.cybertek.ApiShorts.ApiTests;

import static org.testng.Assert.*;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SpartanTestsPOJODeserization {

    @BeforeClass
    public void setUpClass() {
        baseURI = "http://54.234.104.66:8000";
    }

    @Test
    public void test1 () {
      Response response =  given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}");

      // GSON --> de-serialization
      // how to convert json response to our spartan class
        Spartan spartan1 = response.body().as(Spartan.class);

        //System.out.println(spartan1.toString());

        // verify each key with spartan object
        assertEquals(spartan1.getId(), 15);
        assertEquals(spartan1.getName(), "Meta");
        assertEquals(spartan1.getGender(), "Female");
        assertEquals(spartan1.getPhone(), 1938695106);

    }

    @Test
    public void test2(){

         Gson gson = new Gson();

         String myJsonBody = "{\n" +
                 "    \"id\": 15,\n" +
                 "    \"name\": \"Meta\",\n" +
                 "    \"gender\": \"Female\",\n" +
                 "    \"phone\": 1938695106\n" +
                 "}";

         // Using gson method do de serialize our json body
        Spartan spartanMeta = gson.fromJson(myJsonBody, Spartan.class);

        System.out.println(spartanMeta.toString());

        // serialization Java object --> JSON BODY

        Spartan spartan = new Spartan(101, "Mike", "Male", 234567891l);
        // converting custom class to json (seriliazation)
        String jsonbody = gson.toJson(spartan);

        System.out.println(jsonbody);

    }



}
