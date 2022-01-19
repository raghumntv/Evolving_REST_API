import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna").gender("male")
                .email("tenali.ramakrishna195615ce.com").status("active").build();
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
