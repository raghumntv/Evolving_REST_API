import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser(){
        //Arrange
        String email=String.format("%s@gmail.com", UUID.randomUUID());
        String name ="Tenali Ramakrishna";
        String gender ="male";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);
        //Act
        usersClient
                .createUser(requestBody)
                    .then()
                        .log().body()
               //Assert
                        .statusCode(201)
                        .body("data.id", Matchers.notNullValue())
                        .body("data.gender",Matchers.equalTo("male"))
                        .body("data.status",Matchers.equalTo("active"))
                        .body("data.name",Matchers.equalTo("Tenali Ramakrishna"))
                        .body("data.email",Matchers.equalTo(email));

    }
    
    @Test
    public void shouldCreateFemaleUser(){
        //Arrange
        String email=String.format("%s@gmail.com", UUID.randomUUID());
        String name ="Summer";
        String gender ="female";
        String status = "active";
        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);
        //Act
        usersClient
                .createUser(requestBody)
                    .then()
                        .log().body()
                //Assert
                        .statusCode(201)
                        .body("data.id", Matchers.notNullValue())
                        .body("data.gender",Matchers.equalTo("female"))
                        .body("data.status",Matchers.equalTo("active"))
                        .body("data.name",Matchers.equalTo("Summer"))
                        .body("data.email",Matchers.equalTo(email));

    }

}
