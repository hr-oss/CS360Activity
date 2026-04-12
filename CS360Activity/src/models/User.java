package models;

public class User {
    private static int userCount = 0;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userCount++;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static int getUserCount() {
        return userCount;
    }
    
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public String toString() {
        return "Username: " + username + "\nPassword: " + password;
    }
}
