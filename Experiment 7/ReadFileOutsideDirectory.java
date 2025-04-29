import java.io.*;

public class ReadFileOutsideDirectory {
    public static void main(String[] args) {
        
        
        String filePath = "C:/Users/shrut/OneDrive/Desktop/java/Experiment 7/sample.txt";
      
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            
            while ((line = br.readLine()) != null) {
                System.out.println(line);  // Print each line of the file
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
