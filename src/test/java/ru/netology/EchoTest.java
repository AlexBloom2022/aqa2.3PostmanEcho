package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class EchoTest {
    @Test
    public void shouldPostmanEchoTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("wellcome")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("wellcome"))

                .body("headers.content-length", equalTo("8"));
        ;
    }
    @Test
    void shouldPostSomeData() {
        given()

                .baseUri("https://postman-echo.com")
                .body("Something")

                .when()
                .post("/post")

                .then()

                .statusCode(200)
                .body("data", equalTo("Something"))
        ;
    }
}