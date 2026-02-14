
package ClassPackage;

import java.io.*;

public class CashierClass extends UserClass {

   FileSystem fileSystem=new FileSystem("Cashier.txt");

    public CashierClass(String userId, String password) {
        super(userId, password);
        this.userType = "Cashier";
    }

    @Override
    public void login() {
        System.out.println(userId + " logged in as Cashier");
    }

    // Create a new cashier account
    public boolean createCashier(String cashierUsername, String cashierPassword) {
        try (BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedwriter.write(cashierUsername + "," + cashierPassword);
            bufferedwriter.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Verify cashier login (static so you can call without object)
    public static boolean verifyCashier(String username, String password) {
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader("Cashiers.txt"))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
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

   public boolean addCashier() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Cashiers.txt", true))) {
        writer.write(userId + "," + password); // writes credentials to file
        writer.newLine();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
}
