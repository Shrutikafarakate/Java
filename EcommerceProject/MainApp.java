import Ecommerce.Customer;
import Ecommerce.Order;
import Ecommerce.Product;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Customer customer = null;
            Product product = null;
            int choice;

            do {
                System.out.println("\n=== Ecommerce Menu ===");
                System.out.println("1. Enter Customer Details");
                System.out.println("2. Enter Product Details");
                System.out.println("3. Place Order");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Customer ID: ");
                        int customerId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Customer Name: ");
                        String customerName = sc.nextLine();

                        customer = new Customer(customerId, customerName);
                        System.out.println("✅ Customer added.");
                    }

                    case 2 -> {
                        System.out.print("Enter Product ID: ");
                        int productId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String productName = sc.nextLine();

                        System.out.print("Enter Product Price: ");
                        double price = sc.nextDouble();

                        product = new Product(productId, productName, price);
                        System.out.println("✅ Product added.");
                    }

                    case 3 -> {
                        if (customer == null || product == null) {
                            System.out.println("⚠️ Please enter both customer and product details first.");
                            break;
                        }

                        System.out.print("Enter Quantity to Order: ");
                        int quantity = sc.nextInt();

                        System.out.println("\n--- Product Details ---");
                        product.displayDetails();

                        System.out.println("\n--- Customer Details ---");
                        customer.displayCustomer();

                        System.out.println("\n--- Order Summary ---");
                        new Order(product, customer, quantity).placeOrder(); // No need to store in a variable
                    }

                    case 4 -> System.out.println("👋 Exiting... Thank you!");

                    default -> System.out.println("❌ Invalid choice. Please try again.");
                }

            } while (choice != 4);
        }
    }
}
