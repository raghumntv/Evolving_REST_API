import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTests {
    @Test
    public void shouldGetAllUsers(){
        given()
                .when()
                    .get("https://gorest.co.in/public/v1/users")
                .then()
                    .statusCode(200)
                    .log().body();
    }

    @Test
    public void shouldCreateUser(){
        given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization","Bearer c7603baeda0fd898e3ab4f80f49c8cb7e920ee130ba06dbc37b577880128b5ce")
                    .body("{\n" +
                            "  \"name\": \"Tenali Ramakrishna\",\n" +
                            "  \"gender\": \"male\",\n" +
                            "  \"email\": \"tenali.ramakrishna1943@15ce.com\",\n" +
                            "  \"status\": \"active\"\n" +
                            "}")
                .when()
                    .post("https://gorest.co.in/public/v1/users")
                .then()
                    .log().body()
                    .statusCode(201);

    }
}

