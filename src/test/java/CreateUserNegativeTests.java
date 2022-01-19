import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

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
        String email="tenali.ramakrishna195615ce.com";
        String name ="Tenali Ramakrishna";
        String gender ="male";
        String status = "active";
        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);
        //Act
        usersClient
                .createUser(requestBody)
                //Assert
                    .then()
                        .log().body()
                        .statusCode(422)
                        .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                        .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
