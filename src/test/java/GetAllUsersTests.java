import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersTests {
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


}

