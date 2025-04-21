import java.util.Scanner;

interface Shape {
    void area();
}

class Rectangle implements Shape {
    private double length;
    private double breadth;

 
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

   
    @Override
    public void area() {
        double result = length * breadth;
        System.out.println("Area of Rectangle: " + result);
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

   
    @Override
    public void area() {
        double result = 0.5 * base * height;
        System.out.println("Area of Triangle: " + result);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter length of Rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter breadth of Rectangle: ");
        double breadth = scanner.nextDouble();
        Shape rectangle = new Rectangle(length, breadth);
        rectangle.area();

       
        System.out.print("\nEnter base of Triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height of Triangle: ");
        double height = scanner.nextDouble();
        Shape triangle = new Triangle(base, height);
        triangle.area();

        scanner.close();
    }
}
