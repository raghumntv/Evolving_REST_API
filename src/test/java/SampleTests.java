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
                        .log().body();
    }
}
