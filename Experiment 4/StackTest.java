import java.util.Scanner;

interface Stack {
    int size = 5;

    void push(int element);
    void pop();
    void display();
    boolean overflow();
    boolean underflow();
}

class IntegerStack implements Stack {
    private int[] stack = new int[size];
    private int top = -1;

    @Override
    public void push(int element) {
        if (overflow()) {
            System.out.println("Stack Overflow! Cannot push " + element);
        } else {
            stack[++top] = element;
            System.out.println("Pushed: " + element);
        }
    }

    @Override
    public void pop() {
        if (underflow()) {
            System.out.println("Stack Underflow! Cannot pop.");
        } else {
            System.out.println("Popped: " + stack[top--]);
        }
    }

    @Override
    public void display() {
        if (underflow()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean overflow() {
        return top == size - 1;
    }

    @Override
    public boolean underflow() {
        return top == -1;
    }
}

public class StackTest {
    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();
        Scanner scanner = new Scanner(System.in);
        int choice, element;

        do {
            System.out.println("\n--- Stack Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
