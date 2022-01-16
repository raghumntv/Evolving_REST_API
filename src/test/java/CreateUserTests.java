import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser(){
        //Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna1954@15ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        createUser(body)
                .then()
                .log().body()
       //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.gender",Matchers.equalTo("male"))
                .body("data.status",Matchers.equalTo("active"))
                .body("data.name",Matchers.equalTo("Tenali Ramakrishna"))
                .body("data.email",Matchers.equalTo("tenali.ramakrishna1954@15ce.com"));

    }
    
    @Test
    public void shouldCreateFemaleUser(){
        //Arrange
        String body = "{\n" +
                "  \"name\": \"Summer\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Summer004@15ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.gender",Matchers.equalTo("female"))
                .body("data.status",Matchers.equalTo("active"))
                .body("data.name",Matchers.equalTo("Summer"))
                .body("data.email",Matchers.equalTo("Summer004@15ce.com"));

    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer c7603baeda0fd898e3ab4f80f49c8cb7e920ee130ba06dbc37b577880128b5ce")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }


}
