import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {

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
        new UsersClient().createUser(body)
                .then()
                .log().body()
                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
