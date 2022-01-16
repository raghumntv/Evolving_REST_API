import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

public class CreateUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna195615ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        usersClient
                .createUser(body)
                //Assert
                    .then()
                        .log().body()
                        .statusCode(422)
                        .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                        .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
