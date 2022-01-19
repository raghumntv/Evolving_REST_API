import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import java.util.UUID;

import static org.testng.Assert.assertEquals;

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
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

        //Assert
        assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("email","is invalid");

    }
    @Test
    public void shouldNotAllowToCreateUserWithBlankGenderAndStatus(){
        //Arrange
        String email=String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna").gender("")
                .email(email).status("").build();
        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

        //Assert
        assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("gender","can't be blank");
        errorResponse.assertHasError("status","can't be blank");

    }
}
