package user_login;

public class AuthService {

    private final User storedUser;

    public AuthService(User storedUser) {
        this.storedUser = storedUser;
    }

    public boolean authenticate(String username, String password) {
        String hashedInput = PasswordUtils.hashPassword(password);

        return storedUser.getUsername().equals(username)
                && storedUser.getHashedPassword().equals(hashedInput);
    }
}
