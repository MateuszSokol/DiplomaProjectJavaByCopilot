package user_login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {

    @Test
    void testHashPassword_NotNull() {
        String hash = PasswordUtils.hashPassword("test123");
        assertNotNull(hash);
    }

    @Test
    void testHashPassword_Consistent() {
        String hash1 = PasswordUtils.hashPassword("abc");
        String hash2 = PasswordUtils.hashPassword("abc");

        assertEquals(hash1, hash2);
    }

    @Test
    void testHashPassword_DifferentInputsProduceDifferentHashes() {
        String hash1 = PasswordUtils.hashPassword("password1");
        String hash2 = PasswordUtils.hashPassword("password2");

        assertNotEquals(hash1, hash2);
    }
}
