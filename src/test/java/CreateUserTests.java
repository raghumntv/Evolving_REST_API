import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser(){
        //Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna1958@15ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
       //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.gender",Matchers.equalTo("male"))
                .body("data.status",Matchers.equalTo("active"))
                .body("data.name",Matchers.equalTo("Tenali Ramakrishna"))
                .body("data.email",Matchers.equalTo("tenali.ramakrishna1958@15ce.com"));

    }
    
    @Test
    public void shouldCreateFemaleUser(){
        //Arrange
        String body = "{\n" +
                "  \"name\": \"Summer\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Summer008@15ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.gender",Matchers.equalTo("female"))
                .body("data.status",Matchers.equalTo("active"))
                .body("data.name",Matchers.equalTo("Summer"))
                .body("data.email",Matchers.equalTo("Summer008@15ce.com"));

    }

}
