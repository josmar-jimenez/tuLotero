package com.tulotero.chispazo.infraestructure;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
class ChispazoResourceIT {

    @Test
    public void testNextOpenedDrawShouldReturnDraw3() {
        given()
                .when().get("/rest/chispazo/draws/opened/next")
                .then()
                .statusCode(200)
                .body("drawId", is(3));
    }
}