import java.util.Scanner;
class Student {
    protected int rollNo;

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }
}

class Test extends Student {
    protected int sub1;
    protected int sub2;

    public void setMarks(int sub1, int sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    public void getMarks() {
        System.out.println("Subject 1 Marks: " + sub1);
        System.out.println("Subject 2 Marks: " + sub2);
    }
}

interface Sports {
    int sMarks = 20; // sports marks (by default final and static)

    void setSportsMarks();
}

class Result extends Test implements Sports {
    private int sportsMarks;

    @Override
    public void setSportsMarks() {
        // Using the interface variable
        this.sportsMarks = sMarks;
    }

    public void displayResult() {
        int total = sub1 + sub2 + sportsMarks;
        System.out.println("\n--- Student Result ---");
        System.out.println("Roll No: " + getRollNo());
        getMarks();
        System.out.println("Sports Marks: " + sportsMarks);
        System.out.println("Total Marks: " + total);
    }
}

public class StudentResultTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Result result = new Result();

        System.out.print("Enter Roll Number: ");
        int rollNo = scanner.nextInt();
        result.setRollNo(rollNo);

        System.out.print("Enter Marks for Subject 1: ");
        int sub1 = scanner.nextInt();
        System.out.print("Enter Marks for Subject 2: ");
        int sub2 = scanner.nextInt();
        result.setMarks(sub1, sub2);

        result.setSportsMarks();

        result.displayResult();

        scanner.close();
    }
}
