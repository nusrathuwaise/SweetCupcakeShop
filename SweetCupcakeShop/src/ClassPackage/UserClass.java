
package ClassPackage;

public class UserClass {
    protected String userId;      // accessible in subclasses
    protected String password;
    protected String userType;

    public UserClass(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.userType = "User";
    }

     // Default login action (can be overridden)
    public void login() {
        System.out.println(userId + " logged in as " + userType);
    }

    // Default validation (optional)
    public boolean validateLogin() {
        // Simple check: userId and password not empty
        return userId != null && !userId.isEmpty() && password != null && !password.isEmpty();
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
    
}
