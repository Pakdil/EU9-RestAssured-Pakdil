package com.cybertek.Day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersApiTest {

    /*
    Json data has following
     "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": 1938695106
     */

    @DisplayName("OneSpartan with Hamcrest and chaining")
    @Test
    public void test1() {

        given()
                .accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when()
                .get("http://54.234.104.66:8000/api/spartans/{id}")  // Reqest

                .then() // Response
                .statusCode(200)
                .and().assertThat()
                .contentType("application/json")
                .and()
                .body("id", equalTo(15),
                        "name", is("Meta"),
                        "gender", is("Female"),
                        "phone", is(1938695106));


    }
}
