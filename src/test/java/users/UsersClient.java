package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.getAll.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer c7603baeda0fd898e3ab4f80f49c8cb7e920ee130ba06dbc37b577880128b5ce")
                    .body(body)
                .when()
                            .post("https://gorest.co.in/public/v1/users");
        response
                .then()
                    .log().body();

        return response;
    }

    public GetAllUsersResponse getAllUsers() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response
                .then()
                    .log().body();
        int statusCode= response.statusCode();
        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(statusCode);
        return getAllUsersResponse;
    }
}
