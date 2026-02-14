
package ClassPackage;

import java.io.*;

public class FileSystem {
    private static String FILE_PATH = "C:\\131\\FileFolder\\";
    
    private File file;
    private String fileName;
    
    public FileSystem(String fileName) {
        this.fileName = fileName;
        // You can call createANewFile() only when necessary
        this.file = new File(FILE_PATH + fileName);
    }
    
    // Method to ensure the file exists
    public boolean createANewFile() {
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                    return true;
                } else {
                    System.out.println("Failed to create the file.");
                    return false;
                }
            } else {
                System.out.println("File already exists: " + file.getName());
                return true;
            }
        } catch (IOException ex) {
            System.err.println("Error creating file: " + ex);
            return false;
        }
    }

    // Method to write data to the file
    public boolean writeDataToFile(String record) {
        try {
            // Ensure the file exists before writing
            if (!createANewFile()) {
                return false;
            }

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(record);
            bufferedWriter.newLine();
            bufferedWriter.close(); // Close the writer after writing
            
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e);
            return false;
        }
    }

    // Method to read data from the file
    public BufferedReader readAFile() {
        try {
            // Ensure the file exists before reading
            if (!createANewFile()) {
                System.err.println("File does not exist, unable to read.");
                return null;
            }
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            return bufferedReader;
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex);
            return null;
        }
    }
}

