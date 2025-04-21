package Ecommerce;

public class Order {
    private final Product product;
    private final Customer customer;
    private final int quantity;

    public Order(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public void placeOrder() {
        System.out.println("\n✅ Order Placed Successfully!");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Product: " + product.getName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: $" + calculateTotal());
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }
}
