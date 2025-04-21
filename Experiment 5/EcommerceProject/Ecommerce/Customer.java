package Ecommerce;

public class Customer {
    private final String name;
    private final int customerId;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void displayCustomer() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + name);
    }

    public String getName() {
        return name;
    }
}
