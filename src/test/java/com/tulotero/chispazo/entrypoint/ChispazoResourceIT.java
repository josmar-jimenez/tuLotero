package com.tulotero.chispazo.entrypoint;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
class ChispazoResourceIT {

    @Test
    public void endpointOpenedNext_whenExistsOpenedDraw_shouldReturnDraw() {
        given()
                .when().get("/rest/chispazo/draws/opened/next")
                .then()
                .statusCode(200)
                .body("drawId", is(3));
    }
}