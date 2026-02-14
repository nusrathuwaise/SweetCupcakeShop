
package ClassPackage;

import java.io.*;
import java.util.ArrayList;

public class CupcakeClass {
    private String name;
    private double price;
    private String flavor;
    private String category;

    private final String fileName = "Cupcakes.txt";

    // Constructor
    public CupcakeClass(String name, double price, String flavor, String category) {
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.category = category;
    }

    public CupcakeClass() {
        // Empty constructor for search/view
    }

    // Add new cupcake to file
    public boolean addCupcake() {
        try (BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedwriter.write(name + "," + price + "," + flavor + "," + category);
            bufferedwriter.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // View all cupcakes
    public ArrayList<String> viewCupcakes() {
        ArrayList<String> cupcakes = new ArrayList<>();
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                cupcakes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cupcakes;
    }

    // Search cupcake by name
    public ArrayList<String> searchCupcake(String searchName) {
        ArrayList<String> results = new ArrayList<>();
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                if (line.toLowerCase().contains(searchName.toLowerCase())) {
                    results.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    // Getters & Setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getFlavor() { return flavor; }
    public String getCategory() { return category; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setFlavor(String flavor) { this.flavor = flavor; }
    public void setCategory(String category) { this.category = category; }

    public ArrayList<CupcakeClass> getAllCupcakes() {
    ArrayList<CupcakeClass> cupcakeList = new ArrayList<>();
    try {
        File file = new File(fileName);
        if (!file.exists()) {
            return cupcakeList;
        }

        BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedreader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 4) {
                CupcakeClass c = new CupcakeClass();
                c.setName(data[0]);
                c.setPrice(Double.parseDouble(data[1]));
                c.setFlavor(data[2]);
                c.setCategory(data[3]);
                cupcakeList.add(c);
            }
        }
        bufferedreader.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return cupcakeList;
}    
    
}
