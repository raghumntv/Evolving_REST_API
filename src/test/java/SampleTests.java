import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTests {
    @Test
    public void shouldGetAllUsers(){
        //Arrange
        given()
           //Act
                .when()
                    .get("https://gorest.co.in/public/v1/users")
                //Assert
                .then()
                    .statusCode(200)
                    .body("data",Matchers.hasSize(20))
                    .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                    .log().body();
    }

    @Test
    public void shouldCreateMaleUser(){
        //Arrange
        given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization","Bearer c7603baeda0fd898e3ab4f80f49c8cb7e920ee130ba06dbc37b577880128b5ce")
                    .body("{\n" +
                            "  \"name\": \"Tenali Ramakrishna\",\n" +
                            "  \"gender\": \"male\",\n" +
                            "  \"email\": \"tenali.ramakrishna1971@15ce.com\",\n" +
                            "  \"status\": \"active\"\n" +
                            "}")
                //Act
                .when()
                    .post("https://gorest.co.in/public/v1/users")
                //Assert
                    .then()
                        .log().body()
                        .statusCode(201)
                        .body("data.id", Matchers.notNullValue())
                        .body("data.name",Matchers.equalTo("Tenali Ramakrishna"))
                        .body("data.email",Matchers.equalTo("tenali.ramakrishna1971@15ce.com"));
    }

}

