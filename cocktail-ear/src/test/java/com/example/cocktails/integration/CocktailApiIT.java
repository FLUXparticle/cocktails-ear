package com.example.cocktails.integration;

import io.restassured.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CocktailApiIT {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/cocktails/api";
    }

    @Test
    public void testGetAllCocktails() {
        given()
           .log().all()
        .when()
           .get("/cocktails")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    public void testGetCocktailById() {
        when()
            .get("/cocktails/1")
        .then()
            .statusCode(200)
            .body("name", notNullValue());
    }

    // Weitere Tests...

}
