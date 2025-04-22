import java.util.Scanner;

class DivisionException extends Exception {
    public DivisionException(String message) {
        super(message);
    }
}


class Calculator {
    public int divide(int a, int b) throws DivisionException {
        if (b == 0) {
            throw new DivisionException("Division by zero is not allowed.");
        }
        return a / b;
    }
}


public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter numerator: ");
        int a = sc.nextInt();

        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        try {
            int result = calc.divide(a, b);
            System.out.println("Result: " + result);
        } catch (DivisionException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
