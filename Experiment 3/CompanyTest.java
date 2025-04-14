import java.util.ArrayList;
import java.util.List;


abstract class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

  
    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

   
    public abstract double calculateBonus();

    public void generatePerformanceReport() {
        System.out.println("\n--- Performance Report ---");
        System.out.println("Name: " + name);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
    }

    public abstract void manageProjects();
}

// Manager class
class Manager extends Employee {
    private List<String> projects;

    public Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
        projects = new ArrayList<>();
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20; // 20% bonus
    }

    @Override
    public void manageProjects() {
        System.out.println(name + " is managing the following projects: " + projects);
    }

    public void assignProject(String project) {
        projects.add(project);
        System.out.println(project + " assigned to " + name);
    }
}

class Developer extends Employee {
    private List<String> projects;

    public Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
        projects = new ArrayList<>();
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15; // 15% bonus
    }

    @Override
    public void manageProjects() {
        System.out.println(name + " is working on the following projects: " + projects);
    }

    public void assignProject(String project) {
        projects.add(project);
        System.out.println(project + " assigned to " + name);
    }
}

class Programmer extends Employee {
    private List<String> projects;

    public Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
        projects = new ArrayList<>();
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10; // 10% bonus
    }

    @Override
    public void manageProjects() {
        System.out.println(name + " is coding the following projects: " + projects);
    }

    public void assignProject(String project) {
        projects.add(project);
        System.out.println(project + " assigned to " + name);
    }
}


public class CompanyTest {
    public static void main(String[] args) {
       
        Manager manager = new Manager("Alice", "New York", 90000);
        manager.assignProject("Corporate Strategy");
        manager.assignProject("Budget Planning");
        manager.generatePerformanceReport();
        manager.manageProjects();

       
        Developer developer = new Developer("Bob", "San Francisco", 70000);
        developer.assignProject("Mobile App Development");
        developer.assignProject("Backend API Development");
        developer.generatePerformanceReport();
        developer.manageProjects();

      
        Programmer programmer = new Programmer("Charlie", "Los Angeles", 60000);
        programmer.assignProject("Bug Fixing");
        programmer.assignProject("Feature Implementation");
        programmer.generatePerformanceReport();
        programmer.manageProjects();
    }
}
