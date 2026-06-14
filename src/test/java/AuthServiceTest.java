package user_login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private User storedUser;
    private AuthService authService;

    @BeforeEach
    void setUp() {
        String hashed = PasswordUtils.hashPassword("tajnehaslo");
        storedUser = new User("Mateusz", hashed);
        authService = new AuthService(storedUser);
    }

    // -----------------------------
    // authenticate()
    // -----------------------------
    @Test
    void testAuthenticateSuccess() {
        boolean result = authService.authenticate("Mateusz", "tajnehaslo");
        assertTrue(result);
    }

    @Test
    void testAuthenticateWrongPassword() {
        boolean result = authService.authenticate("Mateusz", "zlehaslo");
        assertFalse(result);
    }

    @Test
    void testAuthenticateWrongUsername() {
        boolean result = authService.authenticate("InnyUser", "tajnehaslo");
        assertFalse(result);
    }

    @Test
    void testAuthenticateCompletelyWrong() {
        boolean result = authService.authenticate("X", "Y");
        assertFalse(result);
    }
}
