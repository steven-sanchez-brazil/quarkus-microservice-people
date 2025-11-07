package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testPeopleEndpoint() {
        given()
          .when().get("/people")
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

}