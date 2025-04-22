import java.util.Scanner;

class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}


class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void balanceEnquiry() {
        System.out.println("Current Balance: $" + balance);
    }

    public void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot deposit a negative amount.");
        }
        balance += amount;
        System.out.println("Deposited $" + amount + ". New Balance: $" + balance);
    }

    public void withdraw(double amount) throws LowBalanceException, NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new LowBalanceException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrew $" + amount + ". New Balance: $" + balance);
    }
}


public class BankAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00); // Initial balance

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        account.balanceEnquiry();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depAmount = sc.nextDouble();
                        account.deposit(depAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withAmount = sc.nextDouble();
                        account.withdraw(withAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for banking with us!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option! Try again.");
                }
            } catch (LowBalanceException | NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
