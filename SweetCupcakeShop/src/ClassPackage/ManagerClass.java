
package ClassPackage;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ManagerClass extends UserClass {

    FileSystem fileSystem=new FileSystem("Managers.txt"); // file for managers

    public ManagerClass(String userId, String password) {
        super(userId, password);
        this.userType = "Manager";
    }

    @Override
    public void login() {
        System.out.println(userId + " logged in as Manager");
    }

    // Example: manager-specific method
    public boolean addManager() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // Create a new manager account
    public boolean createManager(String managerUsername, String managerPassword) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write(managerUsername + "," + managerPassword);
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Verify manager login (static)
    public static boolean verifyManager(String username, String password) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Managers.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
