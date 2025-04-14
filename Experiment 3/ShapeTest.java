
abstract class Shape {
    double dim1;
    double dim2;

   
    Shape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

   
    abstract double area();
}

class Rectangle extends Shape {
    
    Rectangle(double length, double breadth) {
        super(length, breadth);
    }

   
    @Override
    double area() {
        return dim1 * dim2;
    }
}

class Triangle extends Shape {
  
    Triangle(double base, double height) {
        super(base, height);
    }

   
    @Override
    double area() {
        return 0.5 * dim1 * dim2;
    }
}

public class ShapeTest {
    public static void main(String[] args) {
       
        Rectangle rect = new Rectangle(7, 5);
        System.out.println("Area of Rectangle: " + rect.area());

       
        Triangle tri = new Triangle(8, 9);
        System.out.println("Area of Triangle: " + tri.area());
    }
}
