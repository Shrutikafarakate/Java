import java.io.*;

public class FileAnalyzer {
    public static void main(String[] args) {
    
        String filePath = "C:/Users/shrut/OneDrive/Desktop/java/Experiment 7/sample.txt";

        int vowelCount = 0;
        int wordCount = 0;
        int aCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] words = line.trim().split("\\s+"); 
                wordCount += words.length;

            
                for (char ch : line.toLowerCase().toCharArray()) {
                    if (ch == 'a') {
                        aCount++;
                    }
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        vowelCount++;
                    }
                }
            }

            
            System.out.println("Total number of vowels: " + vowelCount);
            System.out.println("Total number of words: " + wordCount);
            System.out.println("Total occurrences of 'a': " + aCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
