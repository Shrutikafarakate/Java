import java.io.*;
import java.util.Scanner;

class Student {
    String name;
    int age;
    double weight;
    double height;
    String city;
    String phoneNumber;

    public Student(String name, int age, double weight, double height, String city, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
}

public class StudentInformation {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        // Accept student information from user
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height: ");
        double height = scanner.nextDouble();

        scanner.nextLine();  // Consume the newline left by nextDouble()

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

      
        Student student = new Student(name, age, weight, height, city, phoneNumber);

       
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("studentInfo.dat"))) {
            dos.writeUTF(student.name);
            dos.writeInt(student.age);
            dos.writeDouble(student.weight);
            dos.writeDouble(student.height);
            dos.writeUTF(student.city);
            dos.writeUTF(student.phoneNumber);
            System.out.println("Student information saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving student information: " + e.getMessage());
        }

       
        try (DataInputStream dis = new DataInputStream(new FileInputStream("studentInfo.dat"))) {
            String retrievedName = dis.readUTF();
            int retrievedAge = dis.readInt();
            double retrievedWeight = dis.readDouble();
            double retrievedHeight = dis.readDouble();
            String retrievedCity = dis.readUTF();
            String retrievedPhoneNumber = dis.readUTF();

           
            System.out.println("\nRetrieved Student Information:");
            System.out.println("Name: " + retrievedName);
            System.out.println("Age: " + retrievedAge);
            System.out.println("Weight: " + retrievedWeight);
            System.out.println("Height: " + retrievedHeight);
            System.out.println("City: " + retrievedCity);
            System.out.println("Phone Number: " + retrievedPhoneNumber);
        } catch (IOException e) {
            System.err.println("Error reading student information: " + e.getMessage());
        }

        // Close the scanner
        scanner.close();
    }
}
