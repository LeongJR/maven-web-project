package first.webapp;

import first.webapp.DatabaseOperations;
import first.webapp.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Junit Tests")
class JUnitTest {

    DatabaseOperations mockDatabase = Mockito.mock(DatabaseOperations.class) ;
    private User user;
    private User user2;
    private ArrayList<User> userlist = new ArrayList<>();

    @BeforeEach
    public void preTestSetup () {

    user = new User ("pepe", "pepega", "pepega@gmail.com", "alien");
    user2 = new User ("pepemi", "doremi", "pepehoho@hotmail.com", "arabian");
    userlist.add(user);
    userlist.add(user2);
    }

    //mock database connection to get userlist, print out all users in user list, assert user1 and 2
    @Test
    @DisplayName("Test get all users")
    void testGetAllUsers () {
        when(mockDatabase.selectAllUsers()).thenReturn(userlist);
        assertEquals(userlist.get(0).getName(),"pepe");
        assertEquals(userlist.get(1).getName(), "pepemi");

    }

    @Test
    @DisplayName("Test set name")
    void testSetName () {
        System.out.println(user.getName());
        user.setName("pepega");
        assertEquals(user.getName(), "pepega");
    }

    @Test
    @DisplayName("Test get name")
    void testGetName (){
        assertEquals(user.getName(), "pepe");
    }

    @Test
    @DisplayName("Test get password and set password")
    void testPWGetSet() {
        user.setPassword("fuckyou");
        assertEquals(user.getPassword(), "fuckyou");
    }

}