package h2;

import models.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoH2TestTest {

    UserDaoH2Test userDaoH2Test;

    @BeforeEach
    void setUp() {

        userDaoH2Test = new UserDaoH2Test();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertUser() {

        System.out.println("Testing inserting a user\n");
        User user = new User("carli12", "password", "Carlos", "Hernandez", "carlos@email.com", 2);
        //userDaoH2Test.insertUser(user, "employee");

        List<User> users = userDaoH2Test.selectAllUsers();
        assertEquals(user.getUsername(), users.get(1).getUsername());
        assertEquals(user.getPassword(), users.get(1).getPassword());
        assertEquals(user.getFirstName(), users.get(1).getFirstName());
        assertEquals(user.getLastName(), users.get(1).getLastName());
        assertEquals(user.getEmail(), users.get(1).getEmail());
        assertEquals(user.getRoleId(), users.get(1).getRoleId());
    }

    @Test
    void selectAllUsers() {

        System.out.println("Testing select all users");

        List<User> users = userDaoH2Test.selectAllUsers();
        assertEquals(userDaoH2Test.selectAllUsers(), users);
    }

    @Test
    void selectUserByUsername() {

        System.out.println("Testing select user by username");

        User user = userDaoH2Test.selectUserByUsername("luismir15");
        List<User> users = userDaoH2Test.selectAllUsers();
        assertEquals(user.getUsername(), users.get(0).getUsername());
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}