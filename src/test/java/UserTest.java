package user_login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserConstructorAndGetters() {
        User user = new User("Mateusz", "hashed123");

        assertEquals("Mateusz", user.getUsername());
        assertEquals("hashed123", user.getHashedPassword());
    }
}
