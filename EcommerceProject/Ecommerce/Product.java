package Ecommerce;

public class Product {
    private final String name;
    private final int productId;
    private final double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
