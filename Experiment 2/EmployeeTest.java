class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = Math.max(monthlySalary, 0.0);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = Math.max(monthlySalary, 0.0);
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getYearlySalary() {
        return monthlySalary * 12;
    }

    public void giveRaise(double percentage) {
        monthlySalary += monthlySalary * (percentage / 100);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sharvari", "Kadam", 3000);
        Employee emp2 = new Employee("Swaraj", "Ptil", 4000);

        System.out.printf("%s %s Yearly Salary: $%.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary());
        System.out.printf("%s %s Yearly Salary: $%.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());

        emp1.giveRaise(10);
        emp2.giveRaise(10);

        System.out.println("\nAfter 10% raise:");
        System.out.printf("%s %s Yearly Salary: $%.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary());
        System.out.printf("%s %s Yearly Salary: $%.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
    }
}
