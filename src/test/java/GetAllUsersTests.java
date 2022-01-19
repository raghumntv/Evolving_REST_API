import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.getAll.GetAllUsersResponse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetAllUsersTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllUsers(){
        GetAllUsersResponse getAllUsersResponse = usersClient.getAllUsers();
        assertEquals(getAllUsersResponse.getStatusCode(),200);
        assertEquals(getAllUsersResponse.getDataList().size(),20);
        assertTrue(getAllUsersResponse.hasMaleUser());
    }

}

