import LibraryManagement.Book;
import LibraryManagement.Member;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book = null;
        Member member = null;
        int choice;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("\n=== Library Menu ===");
                System.out.println("1. Add Book");
                System.out.println("2. Add Member");
                System.out.println("3. View Book Info");
                System.out.println("4. View Member Info");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1 -> {
                        System.out.println("\n--- Add Book ---");
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();

                        book = new Book(title, author, isbn);
                        System.out.println("Book added successfully.");
                    }

                    case 2 -> {
                        System.out.println("\n--- Add Member ---");
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Member ID: ");
                        int memberId = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();

                        member = new Member(name, memberId, email);
                        System.out.println("Member added successfully.");
                    }

                    case 3 -> {
                        System.out.println("\n--- Book Information ---");
                        if (book != null) {
                            book.displayBookInfo();
                        } else {
                            System.out.println("No book data available.");
                        }
                    }

                    case 4 -> {
                        System.out.println("\n--- Member Information ---");
                        if (member != null) {
                            member.displayMemberInfo();
                        } else {
                            System.out.println("No member data available.");
                        }
                    }

                    case 5 -> System.out.println("Exiting... Thank you!");

                    default -> System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 5);
        }
    }
}
