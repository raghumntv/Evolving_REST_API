import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

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
        String body = String.format("{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \"active\"\n" +
                "}",email);
        //Act
        usersClient
                .createUser(body)
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
        String body = String.format("{\n" +
                "  \"name\": \"Summer\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \"active\"\n" +
                "}",email);
        //Act
        usersClient
                .createUser(body)
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
