import MathOperations.CeilOperation;
import MathOperations.FloorOperation;
import MathOperations.RoundOperation;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
           
            FloorOperation floorOperation = new FloorOperation();
            RoundOperation roundOperation = new RoundOperation();
            CeilOperation ceilOperation = new CeilOperation();

            
            while (true) {
                
                System.out.print("Enter a decimal number: ");
                double number = sc.nextDouble();  

               
                System.out.println("\nSelect the operation to perform:");
                System.out.println("1. Floor");
                System.out.println("2. Round");
                System.out.println("3. Ceil");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> System.out.println("\nFloor value: " + floorOperation.performFloor(number));
                    case 2 -> System.out.println("\nRounded value: " + roundOperation.performRound(number));
                    case 3 -> System.out.println("\nCeil value: " + ceilOperation.performCeil(number));
                    case 4 -> {
                        System.out.println("Exiting... Thank you!");
                        return;  
                    }
                    default -> System.out.println("Invalid choice! Please enter a valid option (1-4).");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid decimal number.");
        }
    }
}
